public String[] fetchAllPreference(){
     String[] values = new String();
     int index = 0;
     Map<String,?> allPrefs = prefs.getAll();      

     for(Map.Entry<String,?> entry : allPrefs.entrySet()){
       value[index++] = entry.getValue().toString();
     }
     return values; 
    }