File textFile = new File("input.txt");
try (Scanner sc = new Scanner(textFile)) {
    while (sc.hasNextLine()) {
        if (sc.hasNextInt()) {
            System.out.println("id    = " + sc.nextInt());
            System.out.println("value = " + sc.nextInt());
            if (sc.hasNext("\\|"))
                sc.skip(" \\|");
        } else {
            sc.nextLine(); // skip line if it doens't contain more integers
        }
    }
} catch (FileNotFoundException e) {
    System.out.println("File not found: " + textFile);
}