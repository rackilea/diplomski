public static void main(String[] args) throws Exception {   
    File file = new File("C:\\Users\\Soto\\Downloads\\person.xml");
    Scanner scanner = new Scanner(new FileInputStream(file));
    String lineSeparator = System.getProperty("line.separator"); // Assuming you are on Windows, otherwise set it to \n
    scanner.useDelimiter(lineSeparator);
    ByteArrayOutputStream out = new ByteArrayOutputStream(); // would be a real outputstream, like FileOutputStream
    char LF = 0xA; 

    while (scanner.hasNext()) { // looks up to the next delimiter
        String line = scanner.next();
        line = line.replace("" + LF, "");
        out.write(line.getBytes());
        out.write(lineSeparator.getBytes());
    }

    // the OutputStream now contains the content with new lines but no LF
}