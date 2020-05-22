public static void loadMyProgram() {
    while(programStillLoading) {
        doSomeLoading();
        double loadFraction = howCloseToDone(); // A number between 0 and 1

        System.out.print("[");
        int i = 0;
        for( ; i < (int)(loadFraction * 20); i++)
            System.out.print("=");
        for( ; i < 20; i++)
            System.out.print(" ");
        System.out.print("] " + (int)(loadFraction * 100) + "%");

        System.out.print((char)13);
        //System.out.print((char)0xD); // Same as above, but in hex
        //System.out.print("\r"); // Same as above, but as the symbol
    }

    System.out.println();
}