Map<String, List<ServerMetrics>> metricsHolder = new HashMap<String, List<ServerMetrics>>();
    // Size of thread pool set at 10 - can be increased but increasing it 
    // to more than the number of cores on your computer is probably not 
    // useful, as it seems like your task is CPU-bound
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    for (String alias : serverNames) {
        List<ClientsModel> modelMetadata = getModelAttributes();
        List<MachineInfo> machineInfo = getMachineInfo();

        List<Future<ServerMetrics>> metricsFutureList = new ArrayList<Future<ServerMetrics>>();

        // calling model one by one sequentially
        // is there any way to make this multithreaded?
        for (ClientsModel modelList : modelMetadata) {
            final String modelValue = modelList.getModelValue();
            final String modelId = String.valueOf(modelList.getModelId());

            metricsFutureList.add(executorService.submit(new Callable<ServerMetrics>() {
                @Override
                public ServerMetrics call() throws Exception {

                    // execute my model here and storing the metrics in the list
                    ServerMetrics metrics = TestUtils.executeModelMetrics(machineInfo, modelValue);
                    metrics.setModelId(modelId);
                    return metrics;
                }
            }));

        }
        List<ServerMetrics> metricsList = new ArrayList<ServerMetrics>();
        for (Future<ServerMetrics> future : metricsFutureList) {
            metricsList.add(future.get());
        }
        metricsHolder.put(alias, dynMetricsList);
    }