package com.ggl.testing;

public class Board {

    private String[][] myHidingPlaces;

    // private String myWinner;

    public Board() {
        // this.myWinner = "";
        this.myHidingPlaces = new String[3][5];
        initializeMyHidingPlaces();
    }

    private void initializeMyHidingPlaces() {
        for (int i = 0; i < myHidingPlaces.length; i++) {
            for (int j = 0; j < myHidingPlaces[i].length; j++) {
                myHidingPlaces[i][j] = " ";
            }
        }
        myHidingPlaces[1][2] = "6";
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String wall = "|";

        builder.append(" ");
        for (int i = 0; i < myHidingPlaces.length; i++) {
            if (i < (myHidingPlaces.length - 1)) {
                builder.append("____");
            } else {
                builder.append("___ ");
            }
        }
        builder.append(newLine);

        for (int i = (myHidingPlaces[0].length - 1); i >= 0; i--) {
            for (int j = 0; j < myHidingPlaces.length; j++) {
                builder.append(wall);
                builder.append(" ");
                builder.append(myHidingPlaces[j][i]);
                builder.append(" ");
            }
            builder.append(wall);
            builder.append(newLine);

            for (int j = 0; j < myHidingPlaces.length; j++) {
                builder.append(wall);
                builder.append("___");
            }
            builder.append(wall);
            builder.append(newLine);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);
    }

}