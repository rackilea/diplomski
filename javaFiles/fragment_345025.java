static void runSimplePipeline(PipelineOptionsCustom options) {
    Pipeline p = Pipeline.create(options);

    PCollection<Void> results = p.apply("ReadLines", TextIO.read().from(options.getInputFile()))
            .apply("TransformData", ParDo.of(new DoFn<String, KV<String, String>>() {
                @ProcessElement
                public void processElement(ProcessContext c) {
                    Gson gson = new GsonBuilder().create();
                    ObjectMapper oMapper = new ObjectMapper();
                    JSONObject obj_key = new JSONObject();
                    JSONObject obj_value = new JSONObject();
                    List<String> listMainKeys = Arrays
                            .asList(new String[] { "EBELN", "AEDAT", "BATXT", "EKOTX", "Land1", "WAERS" });

                    HashMap<String, Object> parsedMap = gson.fromJson(c.element().toString(), HashMap.class);
                    parsedMap.remove("schema");

                    Map<String, String> map = oMapper.convertValue(parsedMap.get("payload"), Map.class);
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (listMainKeys.contains(entry.getKey())) {
                            obj_key.put(entry.getKey(), entry.getValue());
                        } else {
                            obj_value.put(entry.getKey(), entry.getValue());
                        }

                    }
                    KV objectKV = KV.of(obj_key.toJSONString(), obj_value.toJSONString());
                    c.output(objectKV);

                }
            })).apply("Group By Key", GroupByKey.<String, String>create())
            .apply("Continue Processing", ParDo.of(new DoFn<KV<String, Iterable<String>>, Void>() {
                @ProcessElement
                public void processElement(ProcessContext c) {
                    System.out.print(c.element());
                }
            }));

    p.run().waitUntilFinish();
}