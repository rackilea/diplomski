Data data = new Data();
data.asin = "foo";
data.asintype = "bar";
data.appname = "baz";

// Jackson JSON object mapper
ObjectMapper mapper = new ObjectMapper();

// write to file
mapper.writeValue("c:\\data.json", data);

// write to string
String str = mapper.writeValueAsString(data);
System.out.println(str);