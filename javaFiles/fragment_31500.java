public boolean accept(File file) {
   return accept( file.getPath() );
}

public boolean accept(File dir, String name) {
  //use normalize to account for possible double separators or windows paths which use \
  return accept( FilenameUtils.normalize( dir.getPath() + "/" + name ) );
}

protected boolean accept( String path ) {     
   for (String nameSuffix: names) {
     if (caseSensitivity.checkEndsWith( path, nameSuffix )) {
         return true;
     }
   }
   return false;
}