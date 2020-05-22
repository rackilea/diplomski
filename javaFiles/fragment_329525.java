Path repertoire = Paths.get("[repertoire]");
try ( DirectoryStream<Path> stream = Files.newDirectoryStream(repertoire, new DirectoryStream.Filter<Path>() {
        @Override
        public boolean accept(Path entry) throws IOException {
            return Files.getLastModifiedTime(entry, LinkOption.NOFOLLOW_LINKS).toMillis() = [DATE_SEARCHED (long)] 
        }
 })){

     for (Path path : stream) {
          // Path filtered...
     }
 }