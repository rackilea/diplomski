public static void main( String[] args ) {
        SpringApplication springApplication = new SpringApplication( DevicePeersApplication.class );
        ConfigurableApplicationContext appContext = springApplication.run( args );
        JpaVendorAdapter jpaVendorAdapter = appContext.getBean( JpaVendorAdapter.class );
        log.debug( "JPA Vendor Adapter: {}", jpaVendorAdapter.getClass().getName() );
        log.debug( "JPA Dialect: {}", jpaVendorAdapter.getJpaDialect().getClass().getName() );
        ...
}

2019-04-17 02:02:59.226 DEBUG 12724 --- [           main] c.c.n.d.Application           : JPA Vendor Adapter: org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
2019-04-17 02:02:59.226 DEBUG 12724 --- [           main] c.c.n.d.Application           : JPA Dialect: org.springframework.orm.jpa.vendor.HibernateJpaDialect