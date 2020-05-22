public static Student readFrom( Scanner source ) {
   this.fileName  = source.nextLine();
   this.fileGrade = source.nextLine();
   this.fileMajor = source.nextLine();
   this.fileYear  = Integer.parseInt( source.nextLine());
   this.fileId    = Double.parseDouble( source.nextLine());
   return new Student( fileName, fileGrade, fileMajor,  fileYear, fileId );
}