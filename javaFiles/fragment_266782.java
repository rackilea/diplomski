int size = jArray.length();
for (int i=0 ; i<size ; i++){
    JSONObject itemInArray = jArray.get(i);
    // get values inside the object, for example :
    String text = itemInArray.getString("text");
}