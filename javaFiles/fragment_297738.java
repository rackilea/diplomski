File base = new File("C:/Users/someUser");
File file = new File("C:/Users/someUser/someDir/someFile.txt");

String relativePath = base.toURI().relativize(file.toURI()).getPath();

System.out.println(relativePath); // prints "someDir/someFile.txt"