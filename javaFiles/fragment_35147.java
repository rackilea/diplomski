for (int k=0; k<chessboard.length ; k++){
         // note the condition here
         if (k != i && chessboard[k] == (chessboard[i]) && chessboard[k] == null){
                 JOptionPane.showMessageDialog(null, "Error! There is a duplicate piece on the chessboard: "+chessboard[k]);
                 System.exit(0);
             }
          }
  break;
  }