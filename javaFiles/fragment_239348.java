public boolean inDirectory(String name) {
      boolean inDir = true;
      for (int i = 0; i < directory.length; i++) {
         if (name.equalsIgnoreCase(directory[i])) {
            inDir = true;
            break;
         }
         else {
            inDir = false;
            break;
         }
      }
      return inDir;
   }