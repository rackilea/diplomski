public static void newFile(String fileContent) {
try {
    String newFileLocation = "C:\\Users\\Shayan\\Desktop\\files2\\final_copy.txt";
    PrintWriter writer = new PrintWriter(new FileOutputStream(new File(newFileLocation),  true /* append = true */));
    writer.write(fileContent);//Writes original file content into new file
    writer.close();
    System.out.println("File Created");
} catch (Exception e) {
    e.printStackTrace();
}