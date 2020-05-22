public static void main(String[] args) {
    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, Object> source = new HashMap<>();
    source.put("A", "This is the title");
    source.put("B", "Here is the body");


    MessageRequest req = objectMapper.convertValue(source, MessageRequest.class);

    System.out.println(req.getTitle());
    System.out.println(req.getBody());

}