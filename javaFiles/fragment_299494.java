ResponseEntity<MysuperClass > apiResponse = restTemplate.exchange(Url, HttpMethod.GET, entity, MysuperClass .class)
MysuperClass anotherObject = apiResponse.getBody(); // I hope that works fine

ModelMapper modelMapper = new ModelMapper();
modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
for(Result result : anotherObject.getResults()) {
  MyClass obj = modelMapper.map(result, MyClass.class);
  System.out.println(obj.getId());
  System.out.println(obj.getUpdated_at());
}