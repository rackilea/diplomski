List<String> prices;
Set<String> letters;
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    prices = reader.lines.collect(Collectors.toList());
}

letters = prices.stream.map(p -> getLetter(p)).collect(Collectors.toSet());
Scanner scanner = new Scanner(System.in);
boolean shouldContinue = true;
while (shouldContinue) {
    System.out.println("Enter Product");
    String product = scanner.nextLine();
    if (product.equals("-1")) {
        shouldContinue = false;
    } else {
        String letter = getLetter(product);
        if (letters.contains(letter) {
            System.out.println("Repeat. Re-enter");
        } else {
            prices.add(product);
            letters.add(letter);
        }
    }
}