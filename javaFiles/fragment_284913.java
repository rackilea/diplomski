for (int i = 0 ; i < array.length; i++ ) {
    int check = input.nextInt();
    if (check > 0)
        array[i] = check;
    else {
        System.out.println("Only positives, try again.");
        i--;
    }
}