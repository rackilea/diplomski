public static void insertRemove() {
    Scanner in = new Scanner(System.in);
    int selection;
    int index;
    do {
        selection = in.nextInt();
        index = getIndexOf(selection);
    } while(index < 0);

    // ask user for a new number
    selection = in.nextInt();
    array[index] = selection;
}