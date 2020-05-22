public static void main (String[] args) {
    String fileName = args[0];
    Scanner fileContents;
    try {
        fileContents = new Scanner(new File(fileName));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    HashMap<String, Integer> organizedCategories = countCategories(fileContents);
    if (args.length > 1) {
        if (!"LOCATION".equals(args[1]) || !"CATCOUNT".equals(args[1])) {
            System.out.println("Invalid Command");
        } else {
            if (args[1].equals("CATCOUNT")) {
            }
            if (args[1].equals("LOCATION")) {
            }
        }
    }
}