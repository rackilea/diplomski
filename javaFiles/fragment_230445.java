public void actionPerformed(ActionEvent e) {

    Tile tile = (Tile) e.getSource();

    if (tilesFlipped < 2) {
       tile.flip();
       flippedTiles[tilesFlipped++] = tile;

       if (tilesFlipped == 1) {
          return;
       }

       if (flippedTiles[0].equals(flippedTiles[1])) {
          tilesFlipped = 0;
          return;

       } else {
          Timer timer = new Timer(1000, new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 2; i++) {
                   flippedTiles[i].flipBack();
                }
                tilesFlipped = 0;
             }
          });
          timer.setRepeats(false);
          timer.start();
       }
    }

 }