public void save() {
   try( PrintWriter outputFile = new PrintWriter("textExport.txt")) {
      for( Student s : studentList ) {
         s.writeTo( outputFile );
      }
      outputFile.close(); // Optional, try() close it in any case.
   }
}