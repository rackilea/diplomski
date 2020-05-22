JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
writer.setDataSource(dataSource);

writer.afterPropertiesSet();