@Bean(name="dataSourceA")
@Primary
public DataSource dataSourceA() throws SQLException {
    ...
}

@Bean(name="sqlSessionFactoryA")
@Primary
public SqlSessionFactory sqlSessionFactoryA() throws Exception {
    ...
}