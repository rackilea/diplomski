package tictactoe;

import java.util.Scanner;
import java.util.*;

public class TicTacToe {

    public static final char[][] theBoard = new char[4][4];
    static Scanner kbd = new Scanner(System.in);

    public static void main(String[] args){


        System.out.println("Hello! Welcome to TicTacToe!");
        System.out.println("Player #1 is X! \nPlayer #2 is Y!");
        System.out.println();
        getBoard();
        System.out.println();
        playGame();

    }

    public static void getBoard(){
        for(int i = 1; i < theBoard.length; i++){
            for(int j = 1; j < theBoard[i].length; j++){
                theBoard[i][j] = '_';
                System.out.print(theBoard[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void playGame(){
        int row = 0;
        int col = 0;
        boolean check = false;
        int count = 0;

        //change this 
        while(count <= 8){
            count++;
            System.out.println();
            System.out.println("Player #1 (X) enter the row and column numbers: ");
            row = kbd.nextInt();
            col = kbd.nextInt();
            System.out.println();


            if (row < 0 || col < 0 || row > theBoard.length
                    || col > theBoard.length) {
                throw new RuntimeException("The numbers should be in range 1-3");
            }

            else if (theBoard[row][col] != '_') {
                throw new RuntimeException("The space already filled!");
            }

            else {
                theBoard[row][col] = 'X';
                for (int i = 1; i < theBoard.length; i++) {
                    for (int j = 1; j < theBoard.length; j++) {
                        System.out.print(theBoard[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            check = checkIfWin();
            //change this
            if((check == true) || (count >= 8)){
                break;
            }


            System.out.println();
            System.out.println("Player #2 (O) enter the row and column numbers: ");
            row = kbd.nextInt();
            col = kbd.nextInt();
            System.out.println();
            count++;

            if (row < 0 || col < 0 || row > theBoard.length
                    || col > theBoard.length) {
                throw new RuntimeException("The numbers should be in range 1-3");
            }

            else if (theBoard[row][col] != '_') {
                throw new RuntimeException("The space already filled!");
            }

            else {
                theBoard[row][col] = 'O';
                for (int i = 1; i < theBoard.length; i++) {
                    for (int j = 1; j < theBoard.length; j++) {
                        System.out.print(theBoard[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            check = checkIfWin();
            if(check == true){
                break;
            }

        }
        System.out.println("The game is tie!");
    }

    private static boolean checkIfWin(){
        boolean result = false;
        int countX = 0;
        int countO = 0;

        //Check 1st line
        for(int i = 1; i < theBoard.length; i++){
            if(theBoard[1][i] == 'X'){
                countX++;
            }
            else if(theBoard[1][i] == 'O'){
                countO++;
            }
            if(countX == 3){
                result = true;
                System.out.println("The Player #1 (X) Wins!");
                break;
            }
            else if(countO == 3){
                result = true;
                System.out.println("The Player #2 (O) Wins!");
                break;
            }
        }
        countX = 0;
        countO = 0;

        //Check 2nd line
        for(int i = 1; i < theBoard.length; i++){
            if(theBoard[2][i] == 'X'){
                countX++;
            }
            else if(theBoard[2][i] == 'O'){
                countO++;
            }
            if(countX == 3){
                result = true;
                System.out.println("The Player #1 (X) Wins!");
                break;
            }
            else if(countO == 3){
                result = true;
                System.out.println("The Player #2 (O) Wins!");
                break;
            }
        }
        countX = 0;
        countO = 0;

        //Check 3d line
        for(int i = 1; i < theBoard.length; i++){
            if(theBoard[3][i] == 'X'){
                countX++;
            }
            else if(theBoard[3][i] == 'O'){
                countO++;
            }
            if(countX == 3){
                result = true;
                System.out.println("The Player #1 (X) Wins!");
                break;
            }
            else if(countO == 3){
                result = true;
                System.out.println("The Player #2 (O) Wins!");
                break;
            }
        }
        countX = 0;
        countO = 0;

        //Check 1s column
        for(int i = 1; i < theBoard.length; i++){
            if(theBoard[i][1] == 'X'){
                countX++;
            }
            else if(theBoard[i][1] == 'O'){
                countO++;
            }
            if(countX == 3){
                result = true;
                System.out.println("The Player #1 (X) Wins!");
                break;
            }
            else if(countO == 3){
                result = true;
                System.out.println("The Player #2 (O) Wins!");
                break;
            }
        }
        countX = 0;
        countO = 0;

        //Check 2nd column
        for(int i = 1; i < theBoard.length; i++){
            if(theBoard[i][2] == 'X'){
                countX++;
            }
            else if(theBoard[i][2] == 'O'){
                countO++;
            }
            if(countX == 3){
                result = true;
                System.out.println("The Player #1 (X) Wins!");
                break;
            }
            else if(countO == 3){
                result = true;
                System.out.println("The Player #2 (O) Wins!");
                break;
            }
        }
        countX = 0;
        countO = 0;

        //Check 3d column
        for(int i = 1; i < theBoard.length; i++){
            if(theBoard[i][3] == 'X'){
                countX++;
            }
            else if(theBoard[i][3] == 'O'){
                countO++;
            }
            if(countX == 3){
                result = true;
                System.out.println("The Player #1 (X) Wins!");
                break;
            }
            else if(countO == 3){
                result = true;
                System.out.println("The Player #2 (O) Wins!");
                break;
            }
        }

        //Check first diagonal
        if(theBoard[1][1] == 'X' && theBoard[2][2] == 'X' && theBoard[3][3] == 'X'){
            result = true;
            System.out.println("The Player #1 (X) Wins!");
        }
        else if(theBoard[1][1] == 'O' && theBoard[2][2] == 'O' && theBoard[3][3] == 'O'){
            result = true;
            System.out.println("The Player #2 (O) Wins!");
        }


        // Check first diagonal
        if (theBoard[1][3] == 'X' && theBoard[2][2] == 'X'&& theBoard[3][1] == 'X'){
            result = true;
            System.out.println("The Player #1 (X) Wins!");
        } else if (theBoard[1][3] == 'O' && theBoard[2][2] == 'O'&& theBoard[3][1] == 'O') {
            result = true;
            System.out.println("The Player #2 (O) Wins!");
        }

        return result;
    }
}