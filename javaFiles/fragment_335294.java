public static void main(String[] args) throws IOException {

    String filename = "test.txt"; // Put your filename
    List fileLines = new ArrayList<>();

    // Make sure to add the "throws IOException" to the method  
    Stream<String> fileStream = Files.lines(Paths.get(filename));
    fileStream.forEach(fileLines::add);        
}