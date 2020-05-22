public static void main(String[] args) {
    // TODO code application logic here
    Scanner kbd = new Scanner(System.in);
    // int[][] totalOpenness = new int[n][n];
    System.out.println("ENTER A SINGLE INTEGER: ");
    int n = kbd.nextInt();
    int[][] totalOpenness = new int[n + 1][n + 1];
    char[][] mazeValue = new char[n + 1][n + 1];
    System.out.println("ENTER A PATH: ");

    String input = ""; //Where we store kbd.next()
    int charPosition = 0; //Our manual counter

    for (int i = 0; i < mazeValue.length; i++) {
        for (int j = 0; j < mazeValue[i].length; j++) {
            if (i == 0 || j == 0 || i == n + 1 || j == n + 1)
                mazeValue[i][j] = 'X';
            else {
                while( input.equals("") || input.length() <= charPosition )
                {
                    input = kbd.next();
                    charPosition = 0;
                }
                mazeValue[i][j] = input.charAt(charPosition);
                charPosition++;
            }
        }
    }
    printMaze(mazeValue);
    System.out.println("");
    openfactor(mazeValue, n);
    System.out.println("");
    horizontalPath(mazeValue, n);
    System.out.println(" ");
    verticalPath(mazeValue,n);
    System.out.println(" ");
    openfactor(mazeValue, n);
    average(mazeValue,n,totalOpenness);
}