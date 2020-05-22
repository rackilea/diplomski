try
    {
      CSVReader csvReader = new CSVReader(new FileReader(fileName),',','"',1);
      Map<String, List<String>> tableandcols = new HashMap<String, List<String>>();
      while((row = csvReader.readNext()) != null) 
      {
        // If map contains state already, add the city to the values list
        if(tableandcols.containsKey(row[0]))
         { 
           tableandcols.get(row[0]).add(row[1);
         }
         // if map doesn't have this state as key, insert a key and value
         else {
           List<String> cities = new ArrayList<>();
           cities.add(row[1]);
           tableandcols.put(row[0], cities);
         }
      }
     } 
     catch(Exception e){
      // log exception
     }