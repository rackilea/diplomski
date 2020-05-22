System.out.println("Coping from:\n\t"+pathOfFile+"\nto\n\t"+pathToSaveInsideZIP);

Files.createDirectories(pathToSaveInsideZIP);  // add this row

Files.copy(pathOfFile, pathToSaveInsideZIP, StandardCopyOption.REPLACE_EXISTING);
System.out.println("Done!!!");