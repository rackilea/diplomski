public static void main(String[] args) throws Exception {
    String oneJson = "{ \"error\": \"message\" }";
    String arrJson = "[{ \"error\": \"message\" }, { \"error\": \"message2\" }]";
    List<Resp> result = eitherObjectOrList(oneJson, Resp.class);
    System.out.println(result);
    result = eitherObjectOrList(arrJson, Resp.class);
    System.out.println(result);
}

public static <A> List<A> eitherObjectOrList(String content, Class<A> c) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    return mapper.readValue(
            content,
            mapper.getTypeFactory().constructCollectionType(List.class, c)
    );
}