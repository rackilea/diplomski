List<File> files = someListOfFilesYouWantToSend;
 out.writeInt(files.size());
 for(File file : files){
   out.writeUTF(path);
   out.writeLong(file.getTotalSpace());
   out.write(Files.readAllBytes(file.toPath()));
 }