ByteArrayOutputStream os = new ByteArrayOutputStream();

JsonFactory jfactory = new JsonFactory();
JsonParser jParser = jfactory.createJsonParser(new FileInputStream(new File("data/json.json")));

if (jParser.nextToken() != JsonToken.START_OBJECT) {
    return;
}
while (jParser.nextToken() != JsonToken.END_OBJECT) {
    String fieldName = jParser.getCurrentName();

    jParser.nextToken();
    if (fieldName.equals("byteProp")) {
        byte[] bytes = new byte[1024];
        int read = 0;
        while (jParser.nextToken() != JsonToken.END_ARRAY) {
            if (read >= bytes.length) {
                os.write(bytes, 0, read);
                os.flush();
                bytes = new byte[1024];
                read = 0;
            }

            bytes[read++] = jParser.getByteValue();
        }
        if (read >= 0) {
            os.write(bytes, 0, read);
            os.flush();
        }
    }
}

System.out.println(new String(os.toByteArray()));