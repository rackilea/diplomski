try {
    inputNum = input.nextInt();
    // ... do domething with inputNum ...
} catch (InputMismatchException e) {
    System.out.println("Invalid input!");
}