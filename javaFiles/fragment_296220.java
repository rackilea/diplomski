private String BASE_URL;
private String HOST_NAME;

public FooClass(@Value("${Example.com}") String hostName){
   this.HOST_NAME = hostName;
   this.BASE_URL="http://"+HOST_NAME+":8080";
}