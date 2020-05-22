minesweeperGrid.forEach((k, v) -> {
    v.stream().forEach(
        square -> {
            if (square.isMineLocatedHere())
                System.out.println("*");
            else
                System.out.println(square.getNumSurroundingMines());
        })
  });