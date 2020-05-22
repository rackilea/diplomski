for (int i = 0; i < arrLength;) { // removed here
    try { 
        System.out.println("Enter an issuer ID# (6 digits) for element #" + i);
        String issuerId = scanner.next();
        System.out.println("Enter an account # (9 digits) for element #" + i);
        String accountNum = scanner.next();
        CreditCardNumber obj = new CreditCardNumber(issuerId, accountNum);
        obj.changeId(issuerId);
        i++; // added here
    } catch (IllegalArgumentException e) {
        System.out.println("Invalid Input, Try Again!"); // don't throw just print
    }
}