// If present in same file 

    @Bean()
@Qualifier("sessionFactory_origin")
   public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(getNormalDataSource());
      sessionFactory.setPackagesToScan(
        new String[] { "<packages>" });
      //If presenst
      sessionFactory.setHibernateProperties(hibernateProperties());

      return sessionFactory;
   }