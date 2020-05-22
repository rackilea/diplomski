while(true) {
    try {
        op=teclado.nextInt();
        break;
    } catch(InputMismatchException ex){
        System.out.println("Invalid character. Try again.");
        teclado.nextLine();
    }
}