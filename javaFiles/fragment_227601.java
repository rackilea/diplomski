public void loadData( File fileName ) {
   try( Scanner scanner = new Scanner( new File( "textImport.txt" ))) {
      while( scanner.hasNext()) {
            studentList.add( Student.readFrom( scanner ));
      }
   }
}