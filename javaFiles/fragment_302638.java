class Drawboard extends JComponent{
     Board board;//un initilized
     public Drawboard() {
         board = new Board();
     }
     .
     ..
     .
     public void paint(Graphics g){ 
       .
       .
        g.setColor(board.getSquare(i, j).getColour());//trying to invoke method on null

       }
      }
     } 
    }