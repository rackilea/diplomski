byte[] cachedFile = cache.get(filename);
if( cachedFile != null ) {
   cachedFile = loadFile( filename);
   cache.put( filename, cachedFile );
}

InputStream stream = new ByteArrayInputStream(cachedFile);
play(stream);