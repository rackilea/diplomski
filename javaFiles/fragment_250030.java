String filePathString = "/Users/basilbourque/" + fileName ;
Path path = Paths.get( filePathString );

if ( Files.exists(path) ) {
     … do nothing
}

if ( Files.notExists(path) ) {
     … proceed with creating new file
}