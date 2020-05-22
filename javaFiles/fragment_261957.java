input = new Scanner(System.in);
        System.out.println("Input the number of sides: ");
boolean invalidInput = true;
do {
    double sideNumber = input.nextDouble();
    if(sideNumber > 2){
       invalidInput = false;
    }else{
    System.out.println("Wrong number of sides!");
    }
}while (invalidInput)