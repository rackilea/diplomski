for (int i = 0 ; i<array.length(); i++)   {
   JSONObject o = array.getJSONObject(i);
   String id = o.getString("id");
   String kec = o.getString("kecamatan");
   String avg = o.getString("avg");
   JSONObject yearObject = o.JSONObject("year");   //get JSONObject 

   Iterator<String> itr = yearObject.keys();
    while(itr.hasNext()) {

        String year = itr.next(); 
       JSONObject obj = o.get("year");                //2015
        System.out.println(obj.getString("id"));      //27
        System.out.println(obj.getString("value"));   //60200
    }

     //Add required fields into `ListItem`
     ListItem item = new ListItem(id,kec,avg,tahun,avg);
     listItems.add(item);
  }