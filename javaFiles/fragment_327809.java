minesweeperGrid.forEach((k, v) -> {
    v.stream().forEach(
        square -> {
            System.out.println(square.isMineLocatedHere()
                    ? "*" : square.getNumSurroundingMines())
        })
  });