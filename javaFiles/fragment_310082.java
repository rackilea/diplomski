try {
    if(num2 == 0){
        throw new ArithmeticException();
    }
} catch (ArithmeticException e) {
    System.out.println("Please input another integer than zero");
}