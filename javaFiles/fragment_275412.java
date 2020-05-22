DraughtsPiece p = new DraughtsPiece(DraughtsPiece.LIGHT_PIECE_COLOUR);
      lightPieces.add(p);

      p = new DraughtsPiece(DraughtsPiece.DARK_PIECE_COLOUR);
      p.addMouseListener(new MouseAdapter(){
          public void mouseEntered(MouseEvent m){
              ((DraughtsPiece) m.getSource()).color=<highlight color goes here>;
              DraughtsBoard.this.repaint(); // see my note
          }
          public void mouseExited(MouseEvent m){
              ((DraughtsPiece) m.getSource()).color=<normal color goes here>;
              DraughtsBoard.this.repaint();
          }
      });
      darkPieces.add(p);