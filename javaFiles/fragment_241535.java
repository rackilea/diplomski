try{
JsonParser parser = new JsonParser();
parser.parse(passed_json_string);
} 
catch(JsonSyntaxException jse){
System.out.println("Not a valid Json String:"+jse.getMessage());
}