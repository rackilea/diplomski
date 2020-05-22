Map<String, String> map = new HashMap<String, String>();
NodeList nodelist = document.getElementsByTagName("customField")

for (int i=0; i<nodelist.getLength(); i++) {
    Element element = (Element) nodelist.item(i);

    String key = element.getAttributes("key");
    String value = element.getAttributes("value");

    map.put(key,value);
}