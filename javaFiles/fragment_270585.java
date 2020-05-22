Settings settings = new Settings()
    .withRenderMapping(new RenderMapping()
    .withSchemata(
        new MappedSchema().withInput("MY_SCHEMA")
                          .withOutput("MY_SCHEMA")
                          .withTables(
         new MappedTable().withInput("CUSTOMER")
                          .withOutput("CUSTOMER1"))));