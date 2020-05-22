String datasetName = "my_dataset_name";
String tableName = "my_table_name";
String fieldName = "string_field";
TableId tableId = TableId.of(datasetName, tableName);
// Table field definition
Field field = Field.of(fieldName, Field.Type.string());
// Table schema definition
Schema schema = Schema.of(field);
TableDefinition tableDefinition = StandardTableDefinition.of(schema);
TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build();
Table table = bigquery.create(tableInfo);