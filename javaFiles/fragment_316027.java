public static void main(String[] args){

        String json="{ \"content\": [  {\"a\":{ \"b\" : \"abcd\", \"c\" : \"bcd\"},\"ab\" : \"123\",\"abc\":{\"id\" : \"12345\", \"name\" : \"abcde\"},\"cd\": \"afsf\"},{\"a\":{\"b\" : \"abcd\",  \"c\" : \"bcd\"},\"ab\" : \"123\",\"abc\":{\"id\" : \"12346\",\"name\" : \"abcde\"},\"cd\": \"afsf\"}]}";
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("content");
        for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject objects = jsonArray.getJSONObject(i);
                    String[] elementNames = JSONObject.getNames(objects); 

                       for (String elementName : elementNames)
                          {
                           if(elementName.equalsIgnoreCase("abc")){
                           JSONObject value = objects.getJSONObject(elementName);
                           String[] elementList = JSONObject.getNames(value); 
                            for(String j:elementList){
                                if(j.equalsIgnoreCase("id")){
                                System.out.println(value.getString("id"));  
                                }
                            }
                          }
                          }

        }
    }

Output:-
12345
12346