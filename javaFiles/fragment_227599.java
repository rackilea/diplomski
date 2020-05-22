public void writeTo( PrintWriter outputFile ) throws IOException {
   outputFile.println( this.fileName );
   outputFile.println( this.fileGrade );
   outputFile.println( this.fileMajor );
   outputFile.println( this.fileYear );
   outputFile.println( this.fileId );
}