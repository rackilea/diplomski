String findWord (String word, ArrayList<String> list) {
   for (int i = 0; i < list.size(); i++) {
      if (word.equals (list.get (i))) {
          return list.get (i);
      }
   }
   return "Word not found";
 }