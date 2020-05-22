private static final String s = 
    "{\"en\": \"foo\", \"jp\": \"bar\"}";
private static final String s2 = 
    "{\"en\":{\"title\":\"f\",\"id\":1},\"jp\":{\"title\":\"b\",\"id\":2}}";

ObjectMapper mapper = new ObjectMapper();

I18NProperty<String> o1 =
    mapper.readValue(s, new TypeReference<I18NProperty<String>>(){});

I18NProperty<TestObject> o2 = 
    mapper.readValue(s2, new TypeReference<I18NProperty<TestObject>>(){});