private static int handleOddNo(int oddNo){
    int initial = oddNo;
    while (initial % 2 == 1) {
        System.out.print("(" + initial + ") ");
        initial = 6 * initial + 2;
        if(initial == 1)
            break;
    }
    return initial;
}

private static int handleEvenNo(int evenNo){
    int initial = evenNo;
    while (initial % 2 == 0) {
        System.out.print("[" + initial + "] ");
        initial = initial / 2;
        if(initial == 1)
            break;
    }
    return initial;
}

public static void main(String args[]) {

    System.out.println("Welcome to The Sequence Generator");

    System.out.println("---------------------------------");

    System.out.println("Please Enter an positive integer no more than 100: ");

    Scanner input = new Scanner(System.in);
    int initial = input.nextInt();

    if (initial >= 100 || initial <= 0) {
        System.out.println("The input is invalid");

    }
    do{
        if (initial % 2 == 0) {
            initial = handleEvenNo(initial);
        }else{
            initial = handleOddNo(initial);
        }
    }while(initial != 1);

}