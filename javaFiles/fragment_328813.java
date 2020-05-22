String json = "<copy paste your json here>";
Someclass someclass = objectMapper.readValue(json, Someclass.class);
String s = someclass.getNameIdmap().get("10.2.1.0");
String[] splits = s.split(" ");
String productType = splits[0].split("=")[1];
String id = splits[1].split("=")[1];
System.out.println(productType + "  " + id);