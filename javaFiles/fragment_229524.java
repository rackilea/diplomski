public static void main(String[] args) throws Exception {
    File file = new File("c:/test.txt"); // Precreate this test file first.
    FileOutputStream output = new FileOutputStream(file); // This opens the file!
    System.out.println(file.delete()); // false
    output.close(); // This explicitly closes the file!
    System.out.println(file.delete()); // true
}