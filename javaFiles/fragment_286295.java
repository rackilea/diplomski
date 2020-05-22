public static void main(String[] args){
    int num1;
    int num2;

    if (args.length != 2){
        System.out.println(Usage: numOfElements1 numOfElments2);
        System.exit(0);
    } else {
        try {
            num1 = Integer.parseInt(args[0]);
            num2 = Integer.parseInt(args[1]);

        } catch (Exception ex) {
            System.out.println("Arguments must be an integers");
            System.exit(1);  
        }
    }
    createArray(num1, num1);
}

static void createArray(int num`, int num2){
     double[] a1 = new double[num1];
     double[] a2 = new double[num2];

     Scanner scanner = new Scanner(System.in);

     for (int i=0; i<=a1.length; i++){
         System.out.println(
                   "Please enter a double for array1[<" + i + ">] ");
         double number1 = scanner.nextDouble();
         a1[i] = number1;

         System.out.println(
                   "Please enter a double for array2[<" + i + ">] "); 
         double number2 = scanner.nextDouble();
         a2[i] = number2;            
     }
 }