Calendar cal = Calendar.getInstance();
        Date now = new Date();
        cal.setTime(now);
        long endTime = cal.getTimeInMillis();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 00);
        long startTime = cal.getTimeInMillis();


        int steps = 0;
        DataSource ESTIMATED_STEP_DELTAS = new DataSource.Builder()
                .setDataType(DataType.TYPE_STEP_COUNT_DELTA)
                .setType(DataSource.TYPE_DERIVED)
                .setStreamName("estimated_steps")
                .setAppPackageName("com.google.android.gms").build();

        // fill result with just the steps from the start and end time of the present day
        PendingResult<DailyTotalResult> result = Fitness.HistoryApi.readDailyTotal(mClient, DataType.AGGREGATE_STEP_COUNT_DELTA);
        DailyTotalResult totalResult = result.await(60, TimeUnit.SECONDS);
        if (totalResult.getStatus().isSuccess()) {
            DataSet totalSet = totalResult.getTotal();
            steps = totalSet.isEmpty() ? -1 : totalSet.getDataPoints().get(0).getValue(Field.FIELD_STEPS).asInt();
        }

        s = String.valueOf(steps);

        DataReadRequest readRequest = queryFitnessData();

        DataReadResult dataReadResult =
                Fitness.HistoryApi.readData(mClient, readRequest).await(1, TimeUnit.MINUTES);
        feedItemList.clear();

        printData(dataReadResult);
        return null;