public static void main(String[] args) {
    int height =7;

    for (int row = height; row > 0; row--)
    {

        for(int space = row; space < height ; space++)

            System.out.print("   ");


        for (int column = 1; column <= row; column++)

            System.out.print("[_]");

        System.out.println();
    }
}