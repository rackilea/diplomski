private String currentFile = "root.txt";

public static final String REGEX = "^.I \\d$";

public void foo() throws Exception{

  Path path = Paths.get("path/to/your/input/file.txt");
  Files.lines(path).forEach(line -> {
    if(line.matches(REGEX)) {
      //Extract the digit and update currentFile
      currentFile = "File DOC_ID_"+line.substring(3, line.length())+".txt";
      System.out.println("Current file is now : currentFile);
    } else {
      System.out.println("Writing this line to "+currentFile + " :" + line);
      //Files.write(...);
    }
  });