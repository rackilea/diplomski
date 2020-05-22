// Read in the String using whatever means is appropriate.
String jsonString = ...;

// Parse using Jackson
ObjectMapper mapper = new ObjectMapper();
List<Merchant> list = Arrays.asList(mapper.readValue(
    jsonString,
    Merchant[].class
);