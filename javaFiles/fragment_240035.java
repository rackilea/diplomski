private void checkMenu() {
    List<String> commonWords = Arrays.asList("and", "or", "not");
    Set<String> commonSet = new HashSet<>(commonWords);

    List<String> menu = Arrays.asList("burger", "fries");
    Set<String> menuSet = new HashSet<>(menu);

    String input = "burger and fries";
    String[] tokens = input.split(" ");
    for (int x = 0; x < tokens.length; x++) {
        if (!commonSet.contains(tokens[x]) && menuSet.contains(tokens[x])) {
            System.out.println(tokens[x] + " Exist In Menu!");
        }
    }
}