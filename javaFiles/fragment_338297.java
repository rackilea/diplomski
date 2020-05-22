JSONArray jsonArray = response.getJSONArray("Shows");//getting array
     for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject jsonobject= jsonArray.getJSONObject(i);//getting first element 
       String id= jsonobject.getString("id");//getting id
        String Heading= jsonobject.getString("Heading");//getting Heading
         String Category= jsonobject.getString("Category");//getting Category
         String AssetId= jsonobject.getString("AssetId");//getting AssetId

        System.out.println(""+id+""+Heading+""+AssetId+""+Category) ;
     JSONArray jsonObject1= jsonobject.getJSONArray("details"); //getting children array
      for (int j = 0; j < jsonObject1.length(); j++) {
             JSONObject object1 = jsonObject1.getJSONObject(j);
            String id1= object1.getString("id");//getting id
               String date= object1.getString("date");//getting date
            String time= object1.getString("time");//getting time
          System.out.println(""+id1+""+City+""+time) ;

    JSONArray jsonObject2= object1.getJSONArray("details"); //getting children array
     for (int k = 0; k < jsonObject2.length(); k++) {
     JSONObject object2 = jsonObject2.getJSONObject(k);
      String Address= object2.getString("Address");//getting Address
               String City= object2.getString("City");//getting City
          System.out.println(""+Address+""+City) ;
      }    
     }

    }