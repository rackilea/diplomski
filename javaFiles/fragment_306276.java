final String path = "config.properties";

Properties props = new Properties().load(new FileInputStream(path));
Enumeration e = props.propertyNames();

while (e.hasMoreElements()) {
    String key = (String) e.nextElement();
    System.out.println(key + "=" + props.getProperty(key));
}