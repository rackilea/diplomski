public static void main(String[] args) {

    final int WIDTH = 7;

    for (int row = 1; row <= (WIDTH); row++)
    {

        for (int col = 1; col <= (WIDTH); col++)
        {
            if (col ==1){
                System.out.print("*");
            }else if (row ==WIDTH){
                System.out.print("*");
            }
            else if (row < col)
            {
                System.out.print("*");
            }

            else
            {
                System.out.print(" ");
            }

        }
        System.out.println();
    }
    System.out.println("\n\nGoodbye!");
}