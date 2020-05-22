StringWriter sw = new StringWriter();
JSONWriter writer = new JSONWriter(sw);
writer.object().key("vertex").array();
for (int i = 0; i < num; i++) {
    writer
        .object() // usr2
            .key("name")
                .object() // usr1
                    .key("type").value("string")
                    .key("value").value("name"+i)
                .endObject()
            .key("_id").value(Integer.toString(i))
            .key("_type").value("vertex")
        .endObject()
        .object() // usr4
            .key("email")
                .object() // usr3
                    .key("type").value("string")
                    .key("value").value("email"+i+"@gmail.com")
                .endObject()
            .key("_id").value(Integer.toString(i+num))
            .key("_type").value("vertex")
        .endObject();
}
writer.endArray().endObject();
String json = sw.toString();