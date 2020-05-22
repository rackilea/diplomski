public static void main(String[] args) {
    double num1,num2;
    String operacia;

    Scanner in=new Scanner (System.in);
    System.out.println("Write 2 numbers");

    num1=in.nextDouble();
    num2=in.nextDouble();

    System.out.println("Choose the operation");
    operacia=in.next();

    if (operacia.equals("+")){
        System.out.println("Your result is "+(num1+num2))   ;
    }
    else if (operacia.equals("-")){
        System.out.println("Your result is  "+(num1-num2))  ;
    }
    else if (operacia.equals("/")){
        System.out.println("Your result is  "+(num1/num2))  ;
    }
    else if (operacia.equals("*")){
        System.out.println("Your result is  "+(num1*num2))  ;
    }
}