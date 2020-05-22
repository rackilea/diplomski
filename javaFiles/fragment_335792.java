static Map<String, String> words = new HashMap<>();

     public Mapping_File(){

             words.put("WCRE", "Working Conference on Reverse Engineering (WCRE");
             words.put("ICSE", "International Conference on Software Engineering (ICSE)");
             words.put("IWSC", "International Workshop on Software Clones (IWSC)");
             words.put("ASE", "Automated Software Engineering (ASE)");
             words.put("ACSAC", "Annual Computer Security Applications Conference (ACSAC)");


     }// end of main method

    public Map  <String, String> getWordsMap(){

            return words;

    }// end of the get method
 }// end of the class