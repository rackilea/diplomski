String filename = "C:\Users\Alexander\Desktop\Hello\Hello2\AudioFile.mp3";

String prefix = FilenameUtils.getPrefix(filename);
System.out.println("Prefix: " + prefix);


String path = FilenameUtils.getPath(filename);
System.out.println("Path: " + path);

String fullPath = FilenameUtils.getFullPath(filename);
System.out.println("Full path: " + fullPath);

String name = FilenameUtils.getName(filename);
System.out.println("Name: " + name);

String baseName = FilenameUtils.getBaseName(filename);
System.out.println("Base name: " + baseName);

String extension = FilenameUtils.getExtension(filename);
System.out.println("Extension: " + extension);