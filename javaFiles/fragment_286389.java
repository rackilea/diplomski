public static void main(String[] args) {
    int[] array = new int[5];
    int target;

    System.out.println("Enter 5 numbers: ");

    for (int i = 0; i < 5; i++) {
        array[i] = console.nextInt();
    }

    System.out.println("Search Number: ");
    target = console.nextInt();
    boolean isFound = false;
    for (int i = 0; i < 5; i++) {
        if (array[i] == target) {
            System.out.println("Position: " + (i + 1));
            isFound = true;
            break;
        }
    }

    if (!isFound) {
        System.out.print("Number not found...");
    }
}