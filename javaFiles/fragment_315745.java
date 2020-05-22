while (one.makeMove() != true){
            System.out.println("Choose a valid move");
            board.showPiecesOnBoard(chessBoard.getData());          
            one.makeMove(); // remove this     
        }   
        board.showPiecesOnBoard(chessBoard.getData());  
        while (two.makeMove() != true){
            System.out.println("Choose a valid move");
            board.showPiecesOnBoard(chessBoard.getData());          
            two.makeMove(); // remove this
        }