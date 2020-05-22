public static void main(String[] args) {

    String name;
    int love;
    Scanner scanIn = new Scanner(System.in);

    System.out.println("How much love do you need?");

    //Scanner has nextInt() which allows you to read integers without you having to convert the type.
    love = scanIn.nextInt();
    for (love = 0; love < 0;)
        System.out.println("Everybody needs some love!");

    for (;love > 10;)
        System.out.println("You cannot handle that much love!");

    for (; love > 0 && love < 10;)
        //no need to use Integer.toString(). Just pass the variable and it will be printed.
        System.out.println("I love you " + love + " ways");

    scanIn.close();

}