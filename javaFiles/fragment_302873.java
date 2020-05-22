Settings settings = new Settings()
    .withRenderMapping(new RenderMapping()
    .withSchemata(
        new MappedSchema().withInput("THE_SCHEMA")
                          .withOutput("THE_SCHEMA")
                          .withTables(
            new MappedTable().withInput("PREDEFINED_TABLE")
                             .withOutput("CHANGED_TABLE")
        )
    ));

// Add the settings to the DSLContext
DSLContext ctx = DSL.using(connection, dialect, settings);

// Run your queries with the above ctx
ctx.select(PREDEFINED_TABLE.COLUMM)
   .from(PREDEFINED_TABLE)
   .fetch();