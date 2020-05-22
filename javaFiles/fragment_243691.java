import java.lang.*;
import java.util.*;
import java.io.*;

public class EightQueens {

  char board[][] = new char[8][8];

  // Eight directions of attack:
  int dr[] = { -1, -1, -1, 0, 1, 1, 1, 0 },
      dc[] = { -1, 0, 1, 1, 1, 0, -1, -1 };

  public void clearBoard() {
    for (int r = 0; r < 8; ++r) {
      for (int c = 0; c < 8; ++c) {
        board[r][c] = ' ';
      }
    }
  }

  public void printBoard() {
    String separator = "+---+---+---+---+---+---+---+---+\n";
    StringBuffer buf = new StringBuffer();
    buf.append(separator);
    for (int r = 0; r < 8; ++r) {
      for (int c = 0; c < 8; ++c) {
        buf.append("| "+board[r][c]+" ");
      }
      buf.append("|\n"+separator);
    }
    System.out.println(buf.toString());
  }

  boolean available(int r, int c) {   // Returns true if no queen is
    for (int i = 0; i < 8; ++i) {     //  attacking this cell.
      int R = r, C = c;
      while (R >= 0 && R < 8 && C >= 0 && C < 8) {
        if (board[R][C] != ' ') {
          return false;
        }
        R += dr[i];                   // Use the directional arrays 
        C += dc[i];                   //  to go along the eight
      }                               //  lanes of attack.
    }
    return true;
  }

  boolean placeQueen(int count) {     // Returns true only on success.
    if (count == 0) {
      return true;                    // All queens have been placed.
    }
    for (int r = 0; r < 8; ++r) {
      for (int c = 0; c < 8; ++c) {
        if (available(r, c)) {
          board[r][c] = 'Q';          // Tentatively place a queen.
          if (placeQueen(count-1)) {  // Notice the decremented count.
            return true;              // If it worked, we're done.
          }
          board[r][c] = ' ';          // If not, remove the queen.
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    EightQueens test = new EightQueens();
    test.clearBoard();
    test.placeQueen(8);
    test.printBoard();
  }
}