Path currentRelativePath = Paths.get("");
Path currentDir = currentRelativePath.toAbsolutePath(); // <-- Get the Path and use resolve on it.
String filename = "data" + File.separatorChar + "foo.txt";
Path filepath = currentDir.resolve(filename);

// "data/foo.txt"
System.out.println(filepath);