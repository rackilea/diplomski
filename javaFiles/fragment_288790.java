Scanner sc = new Scanner(System.in);
private int setInt() {
    int i = -1;
    try {
        i = sc.nextInt();
        if(i < 0) {
            System.out.println("Please enter a positive valid integer");
            i = setInt();
        }
    } catch(InputMismatchException iME) {
        //Clear the scanner of this value
        sc.next();
        System.out.println("Please enter a positive valid integer");
        i = setInt();
    }
    return i;
}