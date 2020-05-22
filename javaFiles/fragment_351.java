public static void main (String[] args) throws java.lang.Exception
{
    String user = "jimin";
    String ssn = "222-11-222";
    String password = "WhatAWonderfulWorldItWouldBe";

    if (! isValidSSN(ssn)) {
        System.err.println("Invalid SSN");
    }

    String xdSsn = getObfuscatedSSN(ssn);

    String xdPw = getObfuscatedPassword(password);

    System.out.printf("%12s\t%s\t%s%n", user, xdSsn, xdPw);

}