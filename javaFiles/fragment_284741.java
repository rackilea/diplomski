public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arHeight = sc.nextInt();
    int arWidth = sc.nextInt();

    int[][] map = new int[arHeight][arWidth];

    for(int i=0; i<arHeight; i++){
        for(int j=0; j<arWidth; j++){
            map[i][j] = sc.nextInt();
        }//end inner for
    }//end outter for

    for(int i=0; i<arHeight; i++){
        for(int j=0; j<arWidth; j++){
            System.out.print(map[i][j] + " ");
        }//end inner for
    }

}