ObjectMapper om = new ObjectMapper();
JsonNode oldNode = om.createObjectNode();

// Writing...
// Create an immutable writer (in this case using the default settings)
final ObjectWriter writer = om.writer();

// Use the writer for thread safe access.
final byte[] bytes = writer.writeValueAsBytes(oldNode);


// Reading...
// Create an immutable reader
final ObjectReader reader = om.reader();

// Use the reader for thread safe access
final JsonNode newNode = reader.readTree(new ByteArrayInputStream(bytes));