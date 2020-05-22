public static void main(String[] args) {

        System.out.print("How many inputs?: ");
        int limit = sc.nextInt();

        double total = 0;

        for(int i = 0; i < limit; i++){
            System.out.print("Value " + (i+1) + ": ");
            total += definedPower(sc.nextInt());
            System.out.println();
        }

        System.out.println("The total is: " + total);
 }

private static double definedPower(int value) {
    double croppedValue =  value % 10;

    double e = (value-croppedValue)/10;

    return Math.pow(e, croppedValue);
}