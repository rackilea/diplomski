//Now your calculations etc are put into this function.
//Now you can write simply myFunction() somewhere else (outside of this function) 
//and the execution of the code where the function is called will be
//stopped and wait until the function is finished (until the code of
//the function is executed)
public static void myFunction() { 

Scanner input = new Scanner(System.in);

System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n","What formula would you like to calculate?","Area of a Circle (AOC)","Circumference of a Circle (COC)","Area of a Trapezoid (AOT)","Volume of a Cylinder (VOC)","Volume of a Sphere (VOS)","Volume of a Cone (VON)");
String formula = input.nextLine();

while((formula.equalsIgnoreCase("AOC"))||(formula.equalsIgnoreCase("COC"))||(formula.equalsIgnoreCase("AOT"))||(formula.equalsIgnoreCase("VOC"))||(formula.equalsIgnoreCase("VOS"))||(formula.equalsIgnoreCase("VON")))
        {
    if(formula.equalsIgnoreCase("AOC"))
    {
        System.out.println("What is the circle's radius?");
        double inputRadius = input.nextDouble();
        System.out.printf("%.2f",Math.PI*(Math.pow(inputRadius,2)));

    }

    if(formula.equalsIgnoreCase("COC"))
    {
        System.out.print("What is the circle's radius?");
    double inputRadius = input.nextDouble();
    System.out.printf("%.2f",2*Math.PI*inputRadius);
    }

    if(formula.equalsIgnoreCase("AOT"))
    {
        System.out.println("What is the height of the trapezoid?");
        double inputHeight = input.nextDouble();
        System.out.println("What is the first length of the trapezoid?");
        double inputLengthFirst = input.nextDouble();
        System.out.println("What is the second length of the trapezoid?");
        double inputLengthSecond = input.nextDouble();
        System.out.printf("%.2f",(1/2)*inputHeight*(inputLengthFirst+inputLengthSecond));
    }

    if(formula.equalsIgnoreCase("VOC"))
    {
        System.out.println("What is the cylinder's radius?");
        double inputRadius = input.nextDouble();
        System.out.println("What is the cylinder's height?");
        double inputHeight = input.nextDouble();
        System.out.printf("%.2f",(Math.PI*(Math.pow(inputRadius,2)*inputHeight)));
    }

    if(formula.equalsIgnoreCase("VOS"))
    {
        System.out.println("What is the sphere's radius?");
        double inputRadius = input.nextDouble();
        System.out.println(( 4.0 / 3.0 ) * Math.PI * Math.pow( inputRadius, 3 ));
        System.out.printf("%.2f",(4.0/3.0)*Math.PI*Math.pow(inputRadius, 3));
    }
    if(formula.equalsIgnoreCase("VON"))
    {
        System.out.println("What is the cone's radius?");
        double inputRadius = input.nextDouble();
        System.out.println("What is the cone's height?");
        double inputHeight = input.nextDouble();
        System.out.printf("%.2f",(1.0/3.0)*Math.PI*(Math.pow(inputRadius,2)*inputHeight));
    }
}
}


public static void main(String[] args) { //the main function, containing only the menu loop
  Scanner input = new Scanner(System.in);
  boolean stop = false;
  while(!stop) { //menu loop
    myFunction(); //Your formulas will be calculated in this function
    System.out.println("Do you want to calculate another formula? 0: no, 1: yes")//ask the user if another calculation shall be done
    int userInput = input.nextInt();
    if (userInput == 0) {//set stop accordingly, stop = true will exit the loop
      stop = true;
    } else if (userInput == 1) { //
      stop = false;
    }

  }
}