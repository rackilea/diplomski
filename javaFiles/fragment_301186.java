public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter the number of rows: ");
    int x = in.nextInt();
    System.out.print("Enter the number of stars: ");
    int y = in.nextInt();

    //loop for x lines
    //This starts at x and goes toward 0
    for(int i = x; i > 0; i--){
        //Insert spaces based on line number
        //This is at the beginning now
        for (int s = 0; s < i; s++)
            System.out.print(" ");

        //Print y stars
        //Removed the space after the asterisk
        for(int j = 0; j < y; j++)
            System.out.print("*");

        System.out.println();
    }
}