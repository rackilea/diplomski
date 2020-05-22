File directory = fc.getSelectedFile();
if ( directory != null && directory.isDirectory() ){
  File[] subFiles = directory.listFiles();
  for ( int i = 0; i < subFiles.length; i++ ){
    listModel.addElement( subFiles[i] );
  }
}