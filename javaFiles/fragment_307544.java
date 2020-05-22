public static void main(String[] args) {

    // Location of file to read
    File file = new File("a.txt");
    List<String> lines = new ArrayList<String>();

    try {

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine();
        }
        scanner.close();
    } catch (FileNotFoundException e) {
     System.out.println("Can't find file");  
    }
}