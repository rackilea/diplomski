ObjectMapper objectMapper = new ObjectMapper();
HashMap<Object, Object> readValue = 
objectMapper.readValue(json.getBytes(), HashMap.class);
for (Map.Entry<Object, Object> e : readValue.entrySet()) {
    System.out.println(e.getKey());
    /* Here check e.getValue() isinstance of Map 
       then iterate that too */
 }