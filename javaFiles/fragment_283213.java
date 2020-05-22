private static Person[] loadFile(File file) {   
    List<String> lines = new ArrayList<>();
    try (Scanner scan1 = new Scanner(file)) {
        while (scan1.hasNext())
            lines.add(scan1.next());
    } catch (IOException e) {
        System.out.println("File read error: " + e.getMessage());
    }