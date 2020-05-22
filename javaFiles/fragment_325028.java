@PostMapping("/update)
public void update(@RequestBody Map<String, Object> userMap) {
    String metaInfoId = userMap.get("metaInfoId");

    ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
    final User user = mapper.convertValue(userMap, User.class);
}