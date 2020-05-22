public ObjectId saveFile(InputStream inputStream, String filename, String folder) { 
    GridFSInputFile gInputFile = gridfs.createFile(inputStream, filename);
    gInputFile.put("path", folder);
    gInputFile.save();
    return ObjectId.massageToObjectId( gInputFile.getId() );
}