Properties properties;
public void init(){
 properties.putAll(defaultProperties);
 properties.putAll(userProperties);
 properties.putAll(System.getProperties());
}