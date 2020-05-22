final CsvMapper<Item> mapper = CsvMapperFactory.newInstance()
    .addAlias("name", "itemName")
    .addAlias("reference #", "reference")
    .addColumnProperty(
        column -> column.getName().startsWith("pf."),
        new RenameProperty(columnName -> columnName.replace("pf.", "prefixedFields_")))
    .newMapper(Item.class);