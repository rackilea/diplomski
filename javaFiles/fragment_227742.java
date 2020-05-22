//This is the routing Datasource in spring context
@Bean
public RoutingDatasource routingDataSource() {
  RoutingDatasource rd = new RoutingDatasource();
  java.util.HashMap ds = new java.util.HashMap();
  ds.put("DB1DS","DB1DS");
  ds.put("DB2DS","DB2DS");
  rd.setTargetDataSources(ds);
  return rd;
}

@Bean
public EntityManagerFactory entityManagerFactory() {
  java.util.Map props = new java.util.HashMap();  
  try{
//This is the magic line.
  ((javax.naming.Context)(new javax.naming.InitialContext())).bind("routingDataSource", ctx.getBean("routingDataSource"));
   }catch(Exception e){}
  props.put("javax.persistence.jtaDataSource", "routingDataSource");
            return Persistence.createEntityManagerFactory(DEFAULT_PERSISTENCE_UNIT,props);
}