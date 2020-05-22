ArrayList<String> list = new ArrayList<>();
ClassLoader classLoader = ClassLoader.getSystemClassLoader();
File file = new File(classLoader.getResource("wordlist.txt").getFile());
try (Scanner fileScanner = new Scanner(file)) {
    while (fileScanner.hasNext()) {
        list.add(fileScanner.nextLine());
    }
} catch (IOException ioe) {
    System.out.println("The file doesn't exists!");
}