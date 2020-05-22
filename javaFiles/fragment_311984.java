input = scanner.nextLine().toLowerCase();
for (int i = 0; i < keywords.length; i++) {
    if (input.contains(keywords[i])) {
        System.out.println("Found keyword!");
        // TODO: You can optimize this
    }
}