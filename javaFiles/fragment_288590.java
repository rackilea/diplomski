int i = 1;
String p;
while ((p = prop.getProperty("Property."+i)) != null) {
  // property #i has value p
  i++;
}