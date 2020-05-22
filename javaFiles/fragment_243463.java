ObjectMapper objectMapper = new ObjectMapper();

// When the result is one object
Response<DistanceStat> res = objectMapper.readValue(data, new TypeReference<Response<DistanceStat>>() {});

// For a collection of objects under result
Response<Collection<DistanceStat>> res = objectMapper.readValue(data, new TypeReference<Response<Collection<DistanceStat>>>() {});