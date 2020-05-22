public static void main(String[] args) throws IOException {

    // Assuming the user input here
    int result = 2;
    for (int a = result; a >= 1; a--) {
        Path path = Paths.get("ScalabilityModel.bbt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        // Used CopyOnWriteArrayList to avoid ConcurrentModificationException
        CopyOnWriteArrayList<String> myList = new CopyOnWriteArrayList<String>(lines);

        // taking index to get the position of line when it matches the string
        int index = 0;
        for (String string : myList) {
            index = index + 1;
            if (string.equalsIgnoreCase("AttackNode")) {
                myList.add(index, "AttackNode" + a);
            }
        }
        Files.write(path, myList, StandardCharsets.UTF_8);
    }
}