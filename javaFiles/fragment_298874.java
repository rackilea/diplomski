DirectoryStream<Path> stream = Files.newDirectoryStream(dir, new DirectoryStream.Filter<Path>() {

        @Override
        public boolean accept(Path entry) throws IOException 
        {
            return Files.isDirectory(entry);
        }
    });

for (Path entry: stream) {
      ...
}