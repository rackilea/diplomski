PCollectionView<Map<String, String>> schemaSideInput = input  
  .apply("Build schema", ParDo.of(new DoFn<KV<Integer, String>, KV<String, String>>() {

    // A map containing field-type pairs
    @StateId("schema")
    private final StateSpec<ValueState<Map<String, String>>> schemaSpec =
        StateSpecs.value(MapCoder.of(StringUtf8Coder.of(), StringUtf8Coder.of()));

    @ProcessElement
    public void processElement(ProcessContext c,
                               @StateId("schema") ValueState<Map<String, String>> schemaSpec) {
      JSONObject message = new JSONObject(c.element().getValue());
      Map<String, String> current = firstNonNull(schemaSpec.read(), new HashMap<String, String>());

      // iterate through fields
      message.keySet().forEach(key ->
      {
          Object value = message.get(key);

          if (!current.containsKey(key)) {
              String type = "STRING";

              try {
                  Integer.parseInt(value.toString());
                  type = "INTEGER";
              }
              catch(Exception e) {}

              // uncomment if debugging is needed
              // LOG.info("key: "+ key + " value: " + value + " type: " + type);

              c.output(KV.of(key, type));
              current.put(key, type); 
              schemaSpec.write(current);
          }
      });
    }
  })).apply("Save as Map", View.asMap());