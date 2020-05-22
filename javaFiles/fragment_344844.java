new File("G:\\Testing\\" + type + "\\" + term).mkdirs(); // create the directory tree if it doesn't exist

String strNewFile = "G:\\Testing\\" + type + "\\" + term + "\\" + name;
File newFile = new File(strNewFile);
Path newFilePath = newFile.toPath();
Path srcFilePath = file.toPath();
Files.copy(srcFilePath, newFilePath);