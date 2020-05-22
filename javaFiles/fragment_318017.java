With HashMap you can have something like,

    List<String> listOfDocs = new ArrayList<String>();
    listOfDocs.add("somePDF");
    listOfDocs.add("someDOC");
    listOfDocs.add("someFormat");

    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(); 
    // key would be your STATUS
    // Values would be ListOfDocs you need.

   map.put("STATUS1", listOfDocs);
   map.put("STATUS2", listOfDocs2);
   map.put("STATUS3", listOfDocs3);