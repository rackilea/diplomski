double x = 0; // or whatever you want x to initially be

if(letter.equals("B")) {
    x = 3;
}
System.out.println(x);

if(plusMinusSign.equals("+")) {
    // x = x + 0.3; // I don't know if you want to modify the variable
    System.out.println(x + 0.3);
} else if(plusMinusSign.equals("-")) {
    // x = x - 0.3; // I don't know if you want to modify the variable
    System.out.println(x - 0.3);
}