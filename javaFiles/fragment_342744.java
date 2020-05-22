String result = "";

        Grid grid = new Grid();
        grid.addMines();
        grid.update();
        grid.gameBoard();
        View view = new View();


        result = grid.toString();
        view.display(result);