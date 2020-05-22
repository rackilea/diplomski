public static void printConnect4Board(){
    final int WIDTH = 6;
    final int HEIGHT = 7;
    int [] [] connect4Board = new int [WIDTH][HEIGHT];
    Scanner input = new Scanner(System.in);
    for(int h = 0; h < HEIGHT; h++){
        System.out.print("|");
        for(int w = 0; w < WIDTH; w++){
            System.out.print("|");
        }
        System.out.println();
    }
}