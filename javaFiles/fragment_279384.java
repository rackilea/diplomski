public void flushAuthenticationCache(String userid) {

    final String domain = "mydomain";
    try {
        ObjectName jaasMgr = new ObjectName("jboss.as:subsystem=security,security-domain=" + domain);
        Object[] params = {userid};
        String[] signature = {"java.lang.String"};
        MBeanServer server = (MBeanServer) MBeanServerFactory.findMBeanServer(null).get(0);
        server.invoke(jaasMgr, "flushCache", params, signature);

        } catch (Throwable e) {
        e.printStackTrace();
      }
}