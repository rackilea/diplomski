public static void main(String[] args)
    {
        Properties properties = new Properties();
        properties.setProperty("javax.jdo.PersistenceManagerFactoryClass",
                "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
        properties.setProperty("javax.jdo.option.ConnectionDriverName","org.h2.Driver");
        properties.setProperty("javax.jdo.option.ConnectionURL","jdbc:h2:~/test");
        properties.setProperty("javax.jdo.option.ConnectionUserName","sa");
        properties.setProperty("javax.jdo.option.ConnectionPassword","");
        properties.setProperty("datanucleus.schema.autoCreateAll","true");

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(properties);
        PersistenceManager pm = pmf.getPersistenceManager();

 pm.currentTransaction().begin();
try {
//...
//You can use your logic here
//...
            pm.currentTransaction().commit();
        }finally {
            if(pm.currentTransaction().isActive())
            {
                pm.currentTransaction().rollback();
            }
            pm.close();
        }

}