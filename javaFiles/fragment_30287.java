public static void main(String[] args)
  {
     String fileName = String.join(File.separator,System.getProperty("user.home"),"Desktop","mary.txt");
    System.out.println(fileName);

    try {
        findAndPrint("lamb", fileName);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}