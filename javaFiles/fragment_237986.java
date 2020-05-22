String json = "{ \"firstname\": \"Richard\", \"surname\": \"Kennard\", \"notes\": \"Software developer\" }";
String jsonSchema = "{ properties: { \"firstname\": { \"required\": true }, \"notes\": { \"large\": true }}}";

...
metawidget.setInspector( new CompositeInspector( new CompositeInspectorConfig().setInspectors(
      new JsonInspector( new JsonInspectorConfig().setInputStream( new ByteArrayInputStream( json.getBytes() ) ) ),
      new JsonSchemaInspector( new JsonInspectorConfig().setInputStream( new ByteArrayInputStream( jsonSchema.getBytes() ) ) ) )