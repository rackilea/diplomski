public static void readFile() throws FileNotFoundException {
    try (Scanner scan = new Scanner(file)) {
        scan.nextLine(); // required because there is one empty line at .txt start
        GrocerieList.foodList.addAll(Arrays.asList(scan.nextLine().replaceFirst("\\.$", "").split(",\\s*")));
        GrocerieList.foodAmount.addAll(Arrays.asList(scan.nextLine().replaceFirst("\\.$", "").split(",\\s*")));
    }
}