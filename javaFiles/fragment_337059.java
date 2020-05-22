public static void cheakwinner(){
  if (board[0][0] == playerX && board[0][1] == playerX && board[0][2] == playerX || /* första raden*/
      board[1][0] == playerX && board[1][1] == playerX && board[1][2] == playerX || /* andra raden*/
      board[2][0] == playerX && board[2][1] == playerX && board[2][2] == playerX || /* tredje raden*/
      board[0][0] == playerX && board[1][0] == playerX && board[2][0] == playerX || /*  första colum*/
      board[0][1] == playerX && board[1][1] == playerX && board[2][1] == playerX || /* andra colum*/
      board[0][2] == playerX && board[1][2] == playerX && board[2][2] == playerX || /* tredje colum*/
      board[0][0] == playerX && board[1][1] == playerX && board[2][2] == playerX || /* snea vänster till höger*/
      board[2][0] == playerX && board[1][1] == playerX && board[0][2] == playerX){ /*snea höger till vänster*/
        System.out.println("Player X has won");
        gameEnd();

    }else if (board[0][0] == playerO && board[0][1] == playerO && board[0][2] == playerO || /* första raden*/
              board[1][0] == playerO && board[1][1] == playerO && board[1][2] == playerO || /* andra raden*/
              board[2][0] == playerO && board[2][1] == playerO && board[2][2] == playerO || /* tredje raden*/
              board[0][0] == playerO && board[1][0] == playerO && board[2][0] == playerO || /*  första colum*/
              board[0][1] == playerO && board[1][1] == playerO && board[2][1] == playerO || /* andra colum*/
              board[0][2] == playerO && board[1][2] == playerO && board[2][2] == playerO || /* tredje colum*/
              board[0][0] == playerO && board[1][1] == playerO && board[2][2] == playerO || /* snea vänster till höger*/
              board[2][0] == playerO && board[1][1] == playerO && board[0][2] == playerO) { /* snea höger till vänster*/
                System.out.println("Player O has won");
                gameEnd();
    }
  }