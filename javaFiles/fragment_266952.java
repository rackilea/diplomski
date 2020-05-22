public static void main (String args[]){
    char column;
    int row;
    Scanner scan = new Scanner(System.in);
    Othello game = new Othello();
    //game.startGame();

    while (true) {

        game.displayBoard();

        do {
            System.out.print("Enter the column, then row, for example (A0): "); 
            String line = scan.nextLine();
            column = line.charAt(0);
            row = Integer.parseInt("" + line.charAt(1));
        } while (!( game.checkColumn(column) && game.checkRow(row) );     //loop until input is valid 

        game.takeTurn(column, row); // Remove game as a parameter here. It is not needed

        // if (gameOver) break; 
    }
}