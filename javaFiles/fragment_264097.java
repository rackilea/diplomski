void recursiveList(File f) { // f could be a file or a directory
      if(f is a file) {
           output file info about f
           return
      }
      // else it's a directory
      for(File entry : f.getChildren()) {
          recursiveList(entry);
      }
      output directory info about f
  }