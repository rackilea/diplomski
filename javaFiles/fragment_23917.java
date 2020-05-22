try{
  startRegistry();
  InitialContext context = createContext();
  MysqlDataSource mysqlDs = new MysqlDataSource();
  context.rebind("jdbc/wczasy", mysqlDs);
} catch (Exception e) {
  System.out.println("Error while binding: " + e.getMessage());
  e.printStackTrace();
}


private static void startRegistry() throws RemoteException {
  LocateRegistry.createRegistry(1099);
  System.out.println("RMI registry ready.");
}

private static InitialContext createContext() throws NamingException {
  Properties env = new Properties();
  env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
  env.put(Context.PROVIDER_URL, "rmi://localhost:1099");
  InitialContext context = new InitialContext(env);
  return context;
}