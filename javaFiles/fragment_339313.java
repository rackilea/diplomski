try
    {
      JSONObject jsonobject = new JSONObject(jsonresult);
      JSONArray jarray = (JSONArray) jsonobject.getJSONArray("message"); 
      for(int i=0;i<jarray.length();i++)
      {
             JSONObject jb = (JSONObject)jarray.get(i);
             String bookid =  jb.getString("new_book_id");  
             JSONArray comment = (JSONArray)jb.getJSONArray("comment_array");
             for(int j=0;j<comment.length();j++)
             {
             JSONObject jb2 = (JSONObject)comment.get(j);
             String com = jb2.getString("com");
             String name = jb2.getString("name");
             Log.i("name is",name);
             }    
      }
   }catch(Exception e)
   {

   }