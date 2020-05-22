ATest a = new ATest();
ObjectMapper mapper = new ObjectMapper(); 
Map<String, Object> data = mapper.readValue(new Gson().toJson(a), Map.class);
List<MutablePair> ret = ObjectToPOJO.getPojoParam("source", data, true);
for (MutablePair key : ret) {
    System.out.println(key.left + "=" + key.right);
}