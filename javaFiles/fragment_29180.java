public static void main(String[] args)
{
    String stringOne = "JAVA";
    String stringTwo = "DJDFKWAUERHFGJAVAORKFLASOWE";

    int begPos = stringTwo.indexOf(stringOne);
    int endPos = begPos + stringOne.length();

    System.out.println(begPos + " " + endPos);

    String stringThree = "......................";
    stringThree = stringThree.substring(0, begPos) + stringOne + stringThree.substring(endPos);

    System.out.println(stringThree);
}