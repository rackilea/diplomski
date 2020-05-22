String myJson = null;
    try {
            myJson = new Scanner(new File("test.json")).useDelimiter("\\Z")
                        .next();

            JSONObject myJsonobject = new JSONObject(myJson);

            System.out.println(myJsonobject.get("dev_status"));
            System.out.println(myJsonobject.get("test"));
        } 
   catch (ParseException e) 
      {
           e.printStackTrace();
      } 
   catch (FileNotFoundException e) 
     {
         e.printStackTrace();
     }