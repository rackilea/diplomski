StringWriter writer = new StringWriter();
TidyJSONWriter json = new TidyJSONWriter(writer);
json.array();
/* loop through your options and create objects as shown below */
json.object();
json.key("text");
json.value("A");
json.key("value");
json.value(10);
json.endObject();

json.object();
json.key("text");
json.value("B");
json.key("value");
json.value(20);
json.endObject();
/* end your array */
json.endArray();
response.getWriter().write(writer.toString());