Map<String, List <Object>> user = 
    mapper.readValue(new File("/home/a/headers.yaml"), Map.class);

for(Map.Entry<String, List<Object>> entry : user.entrySet()) {
    System.out.println(entry.getKey());
    List<Object> values = entry.getValue();
    if(values != null) {
        for (Object value : values) {
            System.out.println("  - " + String.valueOf(value));
        }
    }
}