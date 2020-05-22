public static void freezingSnowing() {
    file = new File(MyWeatherApp.class.getResource
                                (path + "freezingSnowing.txt"));
                   // path to the txt file
                   // where path is the local path to the file
    scanner = new Scanner(file);

    ArrayList<String> garments = new ArrayList<>(10);
    while(scanner.hasNextLine()) {
        garments.add(scanner.nextLine());
    }

    ArrayList<Integer> indices = new ArrayList<>(3);
    for(int i = 0; i < 3; i++) {
        while(true) { // watch out for duplicates
           int rand = (int)(Math.random() * 9);
           if(!indices.contains(rand))
               break;
        }
        indices.add(rand);

    JOptionPane.showMessageDialog(null, "It's is snowing! " +
                "I recommend that you dress very warm " +
                "and wear " + garments.get(indices.get(1)) +
                ", " garments.get(indices.get(2)) +
                " and " + garments.get(indices.get(3)) +
                ".");
}