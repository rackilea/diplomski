try {
    //do something that throws ExceptionA, e.g.
    throw new ExceptionA("I am Exception Alpha!");
}
catch(ExceptionA e) {
    //do something to handle the exception, e.g.
    System.out.println("Message: " + e.getMessage());
}