Set<ObjectName> names = mbeanServer.queryNames(new ObjectName("Catalina:type=Host,*"), null);
Set<String> hostNames = new HashSet<String>();
for (ObjectName on : names) {
    hostNames.add(on.getKeyProperty("host"));
}
for (String str : hostNames) {
    ObjectName[] webapps = (ObjectName[]) mbeanServer.getAttribute(new ObjectName("Catalina:type=Host,host=" + str), "children");
    for (ObjectName ob : webapps) {
        String[] appSpl = ob.getKeyProperty("name").split("//localhost");
        webappNames.add(appSpl[1]);
    }
}