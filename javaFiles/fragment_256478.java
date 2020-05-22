@Bean
public DataSource dataSource(){
    return
        new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .setName("testDB;DB_CLOSE_ON_EXIT=FALSE;MODE=MySQL") 
        .addScript("classpath:db/H2.schema.sql")
        .addScript("classpath:db/H2.data.sql")
        .build();
}