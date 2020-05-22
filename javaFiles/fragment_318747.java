public static void isevennumber(int startwith, int endwith) {
    for (int i = startwith; i <= endwith; i++) {
        if (i % 2 == 0)
            System.out.println("you have entered an even number which is " + i);
        else if (i == startwith)
            System.out.println("you haven't entered an even number");
    }
}