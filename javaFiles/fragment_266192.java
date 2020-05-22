return new Properties() {
    // this is an instance initializer block which pre-sets some properties
    {
         setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
         setProperty("hibernate.show_sql", "true");
         setProperty("hibernate.format_sql", "true");
         setProperty("use_sql_comments", "true");
         setProperty("hibernate.hbm2ddl.auto", "none");
     }
};