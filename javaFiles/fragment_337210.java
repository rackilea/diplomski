private static SessionFactory buildSessionFactory() {
    try {           
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
        .configure( "hibernate.cfg.xml" )
        .build();

        Metadata metadata = new MetadataSources( standardRegistry )
        .getMetadataBuilder()
        .build();

        return metadata.getSessionFactoryBuilder().build();

    }