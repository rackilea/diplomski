import java.util.*;
import java.lang.*;
import java.io.*;

class Program11 {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    System.out.print("Number of lockers:\n");
    int number = input.nextInt(); 
    System.out.print("Show stages [y/n]?\n");
    String show = input.next();
    if(show.equals("y")) 
    {
      for (char[] lockers : getStages(number)) 
      { 
        for (char c : lockers) 
        { 
          System.out.print("" + c); 
        } 
        System.out.println();
      }
    }
  }

  public static char[][] getStages(int n){      
    char[] lockers = new char[n];
    char[][] arrayLockers = new char[n][];
    for (int i = 0; i < n; i++) {
      lockers[i] = 'O';
    }
    arrayLockers[0] = new char[lockers.length];
    System.arraycopy(lockers, 0, arrayLockers[0], 0, lockers.length);
    int cnt = 2;
    for (int i = 1; i < n; i++) {
        for (int j = i; j < n; j += cnt) {
            lockers[j] = 'X';
        }
        arrayLockers[i] = new char[lockers.length];
        System.arraycopy(lockers, 0, arrayLockers[i], 0, lockers.length);
        cnt++;
    }
    return arrayLockers;
  }
}