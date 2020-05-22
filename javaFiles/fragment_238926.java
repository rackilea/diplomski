public static void main(String[] a) {

        double result = 0;
        Scanner calcu = new Scanner(System.in);
        System.out.print("Enter First number: ");
        int numOne = calcu.nextInt();
        System.out.print("Enter Second number: ");
        int numTwo = calcu.nextInt();
        System.out.print("Choose an Operator to use");
        String oparation= calcu.next();

        switch(oparation){
            case "+" :
            result = numOne + numTwo;
            break;

            case "-" :
            result = numOne - numTwo;
            break;

            case "/" :
            result = numOne / numTwo;
            break;

            case "*" :
            result = numOne * numTwo;
            break;
        }
        System.out.println("result is " + result);

   }