@Bean   
    public SqlSessionFactory sqlSessionFactory() throws Exception 
    {     
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setMapperLocations(new Resource[]{resource1, resource2});
        sessionFactory.setDataSource(getDataSource());    
        return sessionFactory.getObject();   
    }