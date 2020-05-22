if (Password.length() < 8) {
    System.out.println("Bruv youre asking to be hacked");
} else if (Password.length() >= 8 && Password.length() <= 10) {
    System.out.println("Medium length of password");
} else if (Password.length() > 10 and Password.length() <= 13) {
    System.out.println("Good password length");
} else if (Password.length() > 13 && Password.length() < 16) {
    ... // you might want to output something for passwords of length between 13 and 16
} else {
    System.out.println("Great password length");
}