// Read from resources folder parallel to src in your project
File file1 = new File("resources/abc.txt");
System.out.println(file1.getAbsolutePath());

// Read from src/resources folder
File file2 = new File(getClass().getResource("/resources/abc.txt").toURI());
System.out.println(file2.getAbsolutePath());