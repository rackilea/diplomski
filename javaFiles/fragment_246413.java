BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
TableId tableId = TableId.of("dataset_name", "table_name");
try {
  HashMap<String,Object> mapResult = new ObjectMapper().readValue(json_string, HashMap.class);
  InsertAllResponse response = bigquery.insertAll(InsertAllRequest.newBuilder(tableId)
    .addRow(UUID.randomUUID().toString(), mapResult)
    .build());
  if (response.hasErrors()) {
    // If any of the insertions failed, this lets you inspect the errors
    for (Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
      System.out.println(entry);
    }
  }
} catch (IOException e) {
  // Failed to Map JSON String
  System.out.println(e);
}