public SameGame(){
        int BoardSize = Integer.parseInt(this.getParameters().getRaw().get(0));

        board = new Button[BoardSize][BoardSize]; //get size of board fro cmd args
        for (int x = 0; x < getBoard().length; x++) {
            for (int y = 0; y < getBoard()[x].length; y++) {
                board[x][y] = new Button();
            }
        }

    }