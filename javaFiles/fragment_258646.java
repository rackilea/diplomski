ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(
    PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

String json = "{\"id\":\"123456\",\"email\":[{\"key\":\"email\",\"value\":\"fakeperson@example.com\"}],\"phone_number\":[{\"key\":\"phone_number\",\"value\":\"1-555-555-1234\"}],\"address\":[{\"key\":\"address\",\"value\":{\"street\":\"123 Main Street\",\"city\":\"New York City\",\"state\":\"NY\",\"zip\":\"12345\"}}]}";

ContactInfo contactInfo = mapper.readValue(json, ContactInfo.class);

String serialized = mapper.writeValueAsString(contactInfo);

System.out.println(json.equals(serialized)); // true