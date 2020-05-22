@Override
protected SessionFactory buildSessionFactory(LocalSessionFactoryBuilder sfb) {
    sfb.buildMappings();
    // For my task we need this
    Iterator<Table> iterator = getConfiguration().getTableMappings();
    while (iterator.hasNext()){
        Table table = iterator.next();
        if(table.getSchema() != null && !table.getSchema().isEmpty()){
            table.setSchema(schemaConfigurator.getSchemaName(table.getSchema()));
        }
    }
    return super.buildSessionFactory(sfb);
}