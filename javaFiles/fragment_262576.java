input
  .apply("Convert to TableRow", ParDo.of(new DoFn<KV<Integer, String>, TableRow>() {
      @ProcessElement
      public void processElement(ProcessContext c) {
          JSONObject message = new JSONObject(c.element().getValue());
          TableRow row = new TableRow();

          message.keySet().forEach(key ->
          {
              Object value = message.get(key);
              row.set(key, value);
          });

        c.output(row);
      }}))
  .apply( BigQueryIO.writeTableRows()
      .to("PROJECT_ID:DATASET_NAME.dynamic_bq_schema")
      .withSchemaFromView(schemaView)
      .withCreateDisposition(BigQueryIO.Write.CreateDisposition.CREATE_IF_NEEDED)
      .withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_APPEND));