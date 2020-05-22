String json =
        "{\n" +
        "  \"timestamp\": \"2019-07-02T13:00:34.090909090+02:00\"\n" +
        "}\n";

ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(new JavaTimeModule());

Foo foo = mapper.readValue(json, Foo.class);