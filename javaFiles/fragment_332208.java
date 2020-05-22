public class Message {
 @IsUniqueId
 private String field1; //
 private String field2;
 private String field3;
 private String field4;
 private List<AnotherObject> arrayOfStuff;  //or you can have List<Map<String,String>> arrayOfStuff
 @JsonProperty("attributes")
 private List<LinkedHashMap<String, String>> attributes; // this is list of map objects
 private List<String> options;
  ....
  }