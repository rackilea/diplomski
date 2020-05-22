while(true) {
    int step1;
    try {
        step1 = s.nextInt();
    } catch (InputMismatchException e) {
        System.out.println("Error! Input accept integers only. Input 1-5 or 9");
        System.out.println("");
    } finally { // Use a finally block to catch the carriage return, no matter if the int that got input was valid or not.
        s.nextLine();
    }
}