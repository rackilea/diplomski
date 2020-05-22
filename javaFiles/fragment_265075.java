// Before you get here, have created your `File` object
JsonFactory jsonfactory = new JsonFactory();
JsonGenerator jsonGenerator = 
    jsonfactory.createJsonGenerator(file, JsonEncoding.UTF8);

jsonGenerator.writeStartArray();

// Note: I don't know what `c` is, but if it's a cursor of some sort it
// should have a "hasNext()" or similar you should be using instead of
// this for loop
for (int i = 0; i < count; i++) {

    jsonGenerator.writeStartObject();

    jsonGenerator.writeStringField("pid", c.getString(c.getColumnIndex("pid")));
    jsonGenerator.writeStringField("status", c.getString(c.getColumnIndex("status")));
    jsonGenerator.writeStringField("pop_time", c.getString(c.getColumnIndex("pop_time")));
    jsonGenerator.writeStringField("punching_time", c.getString(c.getColumnIndex("punching_time")));
    // stores base64encoded picture
    jsonGenerator.writeStringField("picture", c.getString(c.getColumnIndex("image_str")));

    jsonGenerator.writeEndObject();

    c.moveToNext(); // Moving the cursor to the next record
}

jsonGenerator.writeEndArray();
jsonGenerator.close();