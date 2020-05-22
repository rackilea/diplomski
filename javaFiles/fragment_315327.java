String jsonStr = "...";
ObjectMapper mapper = new ObjectMapper();
List<MyPojo> myObjs = mapper.readValue(jsonStr, new TypeReference<List<MyPojo>>() {});
MyPojo myPojo = myObjs.get(0);
myPojo.getData();
myPojo.getWhat();
// and so on