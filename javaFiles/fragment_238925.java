public static void main(String[] a) {

        String[] ans = {"+","-","/","*"};
        double result = 0;
        Scanner calcu = new Scanner(System.in);
        System.out.print("Enter First number: ");
        int numOne = calcu.nextInt();
        System.out.print("Enter Second number: ");
        int numTwo = calcu.nextInt();
        System.out.print("Choose an Operator to use");
        String oparation= calcu.next();

        if(oparation.equals(ans[0])){
           result = numOne + numTwo;
        }
        else if(oparation.equals(ans[1])){
            result = numOne - numTwo;
        }
        else if(oparation.equals(ans[2])){
            result = numOne / numTwo;

        } else if(oparation.equals(ans[3])){
            result = numOne * numTwo;
        }
        System.out.println("result is " + result);

   }