public static int getNumberInput(int bound){
    Scanner input = new Scanner(System.in);
    for (;;) {
        if (!Inputs.isANumber(input)) {
            System.out.println("Negative Numbers and Letters are not allowed");
            input.reset();
            continue;
        }
        int val = getNumberInput();
        if (val <= bound) {
            break;
        }
        System.out.println("Maximum Input is only up to: "+ bound+" Please Try Again: ");
        input.reset();
    }
    return val;
}