try{
    System.out.print("Enter your age : ");
    age = input.nextInt();
}catch(RuntimeException ex){
    System.out.println("Invalid input");
}