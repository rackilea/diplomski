public String rescue() { //class to rescue people or things
       String toReturn = "";
       for(String _key : newMap.keySet()) {
           toReturn += " rescued " + _key + " " + newMap.get(_key) + "pts!";
       }
       return toReturn;
   }