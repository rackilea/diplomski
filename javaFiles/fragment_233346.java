int count_piece = 0;

        //Checking Vertical Win
        for (int row = 0; row < board.length; row++) {
            count_piece = 0;
            for (int column = 0; column < board[row].length; column++) {

                if (board[row][column] == 'X') {
                    count_piece++;
                    if (count_piece == 4) {
                        System.out.println("you win");
                        return;
                    }

                } else {
                    count_piece = 0;
                }


            }
        }

        //Checking Horizontal Win
        for (int column = 0; column < board.length; column++) {
            count_piece = 0;
            for (int row = 0; row < board[column].length; row++) {

                if (board[row][column] == 'X') {
                    count_piece++;
                    if (count_piece == 4) {
                        System.out.println("you win");
                        return;
                    }

                } else {
                    count_piece = 0;
                }


            }
        }