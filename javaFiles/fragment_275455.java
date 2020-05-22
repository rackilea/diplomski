public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println ("Enter a list of integers (Enter 0 when done): ");
    ArrayList<Integer> fullArray = new ArrayList<>();

    while (keyboard.hasNextInt()) {
        int nextValue = keyboard.nextInt();
        if (nextValue == 0) {
            break;
        }
        fullArray.add(nextValue);
        System.out.println (fullArray);
    }
}