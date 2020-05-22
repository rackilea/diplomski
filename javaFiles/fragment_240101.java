System.out.println("Enter the radius pls :");
try {    
    circle1.setRadius(input.nextDouble());
} catch (InputMismatchException e){
    System.out.println("ERROR : Invalid input !");
}