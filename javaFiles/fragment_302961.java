Path path = Paths.get("/path/to/file");
Scanner sc = new Scanner(path);

int counter = 0;
while (sc.hasNext()) {
    String word = sc.next();
    if (word.equalsIgnoreCase("AEIOU")) {
        counter += 1;
    }
}
System.out.print("Number of words: " + counter);