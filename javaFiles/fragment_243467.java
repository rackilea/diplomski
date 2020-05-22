Object resultObject = example.getAdditionalProperties().getKey("results");

if ( resultObject instanceof Collection<?>){

List<Result1> results=resultObject;
}

else{

Result2 results=resultObject;

}