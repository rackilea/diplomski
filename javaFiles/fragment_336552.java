private void closeSessionFactory(SessionFactory factory) { 
   if(factory instanceof SessionFactoryImpl) {
      SessionFactoryImpl sf = (SessionFactoryImpl)factory;
      ConnectionProvider conn = sf.getConnectionProvider();
      if(conn instanceof C3P0ConnectionProvider) { 
        ((C3P0ConnectionProvider)conn).close(); 
      }
   }
   factory.close();
}