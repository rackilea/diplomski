String changePositionResult = null;
do {
    final Scanner keyboard = new Scanner(System.in);
    position = keyboard.nextLine();

    if ("help".equalsIgnoreCase(position)) {
        commands();
    } else if ("turn".equalsIgnoreCase(position)) {
        turn(player1turn);
    } else if ("board".equalsIgnoreCase(position)) {
        printBoard(board);
    } else {
        changePositionResult = changePosition(position, player1turn, board);
        if (!"retry".equalsIgnoreCase(changePositionResult)) {
            System.out.println(changePositionResult);
            if (player1turn == true) {
                player1turn = false;
            } else if (player1turn == false) {
                player1turn = true;
            }
        }
    }
} while ("retry".equals(changePositionResult));