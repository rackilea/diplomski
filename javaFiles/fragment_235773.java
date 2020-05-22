public static void insertRemove() {
    Scanner in = new Scanner(System.in);
    int selection;
    do {
        selection = in.nextInt();
    } while(!checkValid(selection));

    // selection is now valid so do whatever you need to
}

public static boolean checkValid(int selection) {
    for(int i = 0; i < array.length; i++) {
        if(array[i] == selection) {
            return true;
        }
    }

    return false;
}