public static void main(String[] args) {
    boolean invalidInput;
    int q = -1;
    int[] items = { 1, 2, 3, 4 };

    do {
        boolean found = false;
        invalidInput = false;

        System.out.println("Enter the item's code you want to search for : ");
        q = 5;

        for (int i = 0; i < items.length; i++) {
            if (q == items[i]) {
                System.out.println(items[i]);
                found = true;
                System.exit(2);
            }
        }
        if (!found)
            System.out.print("Item not found");
    } while (invalidInput);
}