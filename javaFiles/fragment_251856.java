public static ArrayList<String> getPowerSet(String original) {
       ArrayList<String> toReturn = new ArrayList<String>();

       toReturn.add("");

       for (int i = 0; i < original.length(); i++) {
          for (int j = i + 1; j <= original.length(); j++) {
             toReturn.add(original.substring(i, j));
          }
       }

       return toReturn;
    }