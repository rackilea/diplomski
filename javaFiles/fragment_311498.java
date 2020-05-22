while (input > last){
    try{
        input = scan.nextInt();
        result += input;
        last = input;
    }catch (InputMismatchException e){
        System.err.println("Invalid input"); //you could also use .out
        scan.next(); //eliminate invalid data
    }
}