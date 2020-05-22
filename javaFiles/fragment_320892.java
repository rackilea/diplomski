Enumeration<?> propertyNames = properties.propertyNames();
while (propertyNames.hasMoreElements()) {
    String name = (String) propertyNames.nextElement();
    String value = properties.getProperty(name);
    System.out.println("Name: "+name+"\tValue: "+value);
}