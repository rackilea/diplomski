ObjectMapper mapper = new ObjectMapper();
    String str = "[{\"accno\":9210255,\"type\":\"Stock- and mutual funds account\",\"default\":true,\"alias\":\"Karlsson Joachim\"}]";

    JavaType accountListType =  mapper.getTypeFactory().constructArrayType(Account.class);

    Account[] accounts = SharedJsonSerializer.objectMapper().readValue(str, accountListType);