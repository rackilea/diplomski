JsonFactory factory = new JsonFactory();
JsonParser parser = factory.createParser(json);

while (parser.nextToken() != null) {
    String name = parser.getCurrentName();
    if ("field1".equals(name)) {
        parser.nextToken();                 // Advance to the field value
        String value = parser.getText();    // Get the field value as a string
        System.out.println(value);
    }
}
parser.close();