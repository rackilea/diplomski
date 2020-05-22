JSONArray myListsAll= new JSONArray(myjsonstring);// json array
   JSONObject jsonobject= (JSONObject) myListsAll.get(0); // index 0
   JSONArray json = new JSONArray(jsonobject.getString("events")); // list events
             for(int i=0;i<json.length();i++)
             {
             JSONObject jsonObject1 = (JSONObject) json.get(i);  //
             String time= jsonObject1.getString("time");
             String type= jsonObject1.getString("type"); 
             String title= jsonObject1.getString("title");
             String id= jsonObject1.getString("type_id");
             System.out.println("time="+time);
             System.out.println("type="+type);
             System.out.println("title="+title);
             System.out.println("id="+id);
             }