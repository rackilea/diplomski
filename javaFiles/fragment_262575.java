PCollectionView<Map<String, String>> schemaView = p
  .apply("Start", Create.of("Start"))
  .apply("Create Schema", ParDo.of(new DoFn<String, Map<String, String>>() {
      @ProcessElement
      public void processElement(ProcessContext c) {
        Map<String, String> schemaFields = c.sideInput(schemaSideInput);  
        List<TableFieldSchema> fields = new ArrayList<>();  

        for (Map.Entry<String, String> field : schemaFields.entrySet()) 
        { 
            fields.add(new TableFieldSchema().setName(field.getKey()).setType(field.getValue()));
            // LOG.info("key: "+ field.getKey() + " type: " + field.getValue());
        }

        TableSchema schema = new TableSchema().setFields(fields);

        String jsonSchema;
        try {
            jsonSchema = Transport.getJsonFactory().toString(schema);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        c.output(ImmutableMap.of("PROJECT_ID:DATASET_NAME.dynamic_bq_schema", jsonSchema));

      }}).withSideInputs(schemaSideInput))
  .apply("Save as Singleton", View.asSingleton());