public boolean inDirectory(String name) {
      boolean inDir = false;
      for (int i = 0; i < directory.length; i++) {
         if (name.equalsIgnoreCase(directory[i])) {
            inDir = true;
            break;
         }
      }
      return inDir;
   }