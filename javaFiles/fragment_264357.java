// (1) deserialize JSON
ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
HashMap map = mapper.readValue(
    "{\"from\":\"1\",\"to\":[\"a\",\"b\"]}", HashMap.class);

// (2) reorder stuff (use a new Map object if needed, or delete obsolete keys)
map.put(map.get("from"), map.get("to"));