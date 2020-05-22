public static void main(String[] args) {
    FindFile ff = new FindFile();
    String name = "notepad.exe";
    String directory ="C:\\Windows\\";

    ff.findFile(name,new File(directory));

    System.out.println("---------------");
}