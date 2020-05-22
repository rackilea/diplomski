try {
    throw new ExceptionB("I am Exception Bravo!");
}
catch(ExceptionA e) {
    System.out.println("Message: " + e.getMessage());
}