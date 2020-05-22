while ("retry".equals(changePosition(position, player1turn, board))) { 
        Scanner keyboard = new Scanner (System.in);
        position = keyboard.nextLine();

        if ("help".equalsIgnoreCase(position)) {
            commands();
        }
        else if ("turn".equalsIgnoreCase(position)){
            turn(player1turn);
        }
        else if ("board".equalsIgnoreCase(position)){
            printBoard(board);
        }
        else {
             if (!"retry".equalsIgnoreCase(changePosition(position, player1turn, board))) {
                 System.out.println(changePosition(position, player1turn, board));
                 if (player1turn == true) {
                     player1turn = false;
                 }
                 else if (player1turn == false) {
                     player1turn = true;
                 }
             }
        }
    }
}