public String createSQL() {
    // Create your entity
    TestEntity entity = new TestEntity();
    entity.setSomeProperty("Example");
    ...

    // Write your entity as SQL
    StringWriter result = new StringWriter();
    EntitySqlGenerator sqlGenerator = new EntitySqlGenerator(result);
    sqlGenerator.write(entity);
    return result.toString();
}