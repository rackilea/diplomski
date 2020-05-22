import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public final class Pha extends JFrame {

    //a collection of cells in the path.
    //each cell represented by [row,col]
    private Stack<int[]>path;

    //a path shorter than min can not surround any cell
    private static final int MIN_PATH_LEGTH = 4;

    //a collection of cells that has been tested
    private ArrayList<int[]>checked;

    //represents the cell where the search starts from
    int[] origin;
    //represents the token of the origin
    Token originToken;

    private static int ROWS = 15;
    private static int COLS = ROWS;
    private static int cellSize = 15;
    private static int canvasWidth = (cellSize * COLS) + (ROWS *4) ;
    private static int canvasHeight = cellSize * ROWS ;
    private static int gridWidth = 1;
    private static int halfGridWidth = gridWidth / 2;

    private static int cellPadding = cellSize / 5;
    private static int symbolSize = cellSize - (cellPadding * 2);
    private static int symbolStrokeWidth = 3;

    private enum Token{
        VIDE, CERCLE_ROUGE, CERCLE_BLEU
    }

    private Token[][] board;
    private final DrawCanvas canvas;

    //used to set different test data
    private static int testNumber = 0;

    public Pha(){

        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(canvas, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setTitle("Pha par esQmo");
        setVisible(true);

        board = new Token[ROWS][COLS];
        initGame();

        //fill some data for testing
        int[] origin = loadtestData(board);
        findPath(origin);
    }

    private void initGame(){

        for(int ligne = 0; ligne < ROWS; ++ligne){
            for(int colonne = 0; colonne < COLS; ++colonne){
                board[ligne][colonne] = Token.VIDE;
            }
        }
    }
    //search for a path
    private void findPath(int[] origin) {

        //initialize path and checked
        path = new Stack<>();
        this.origin = origin;

        int row = origin[0] , col =  origin[1];

        //represents the token of the origin
        originToken = board[row][col];

        //initialize list of checked items
        checked = new  CellsList();

        boolean found = findPath(row, col);

        if(found) {
            printPath();
        } else {
            System.out.println("No path found");
        }
    }

    //recursive method to find path. a cell is represented by its row, col
    //returns true when path was found
    private boolean findPath(int row, int col) {

        //check if cell has the same token as origin
        if(board[row][col] != originToken) {
            return false;
        }

        int[] cell = new int[] {row, col};

        //check if this cell was tested before to avoid checking again
        if(checked.contains(cell)) {
            return false;
        }

        //get cells neighbors
        CellsList neighbors = getNeighbors(row, col);

        //check if solution found. If path size > min and cell
        //neighbors contain the origin it means that path was found
        if((path.size() > MIN_PATH_LEGTH) && neighbors.contains(origin)  ) {

            path.add(cell);
            return true;
        }

        //add cell to checked
        checked.add(cell);

        //add cell to path
        path.add(cell);

        //if path was not found check cell neighbors
        for(int[] neighbor : neighbors ) {

            boolean found = findPath(neighbor[0],neighbor[1]);
            if(found) {
                return true;
            }
        }

        //path not found
        path.pop(); //remove last element from stack
        return false;
    }

    //return a list of all neighbors of cell row, col
    private CellsList getNeighbors(int  row, int col) {

        CellsList neighbors = new CellsList();

        for (int colNum = col - 1 ; colNum <= (col + 1) ; colNum +=1  ) {

            for (int rowNum = row - 1 ; rowNum <= (row + 1) ; rowNum +=1  ) {

                if(!((colNum == col) && (rowNum == row))) {

                    if(withinGrid (rowNum, colNum )  ) {

                        neighbors.add( new int[] {rowNum, colNum});
                    }
                }
            }
        }

        return neighbors;
    }

    private boolean withinGrid(int colNum, int rowNum) {

        if((colNum < 0) || (rowNum <0) ) {
            return false;
        }
        if((colNum >= COLS) || (rowNum >= ROWS)) {
            return false;
        }
        return true;
    }

    private void printPath() {
        System.out.print("Path : " );
        for(int[] cell : path) {
            System.out.print(Arrays.toString(cell));
        }
        System.out.println("");
    }

    class DrawCanvas extends JPanel{

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            setBackground(Color.WHITE);

            g.setColor(Color.BLACK);
            for(int ligne = 1; ligne < ROWS; ++ligne){
                g.fillRoundRect(0, (cellSize * ligne) - halfGridWidth, canvasWidth - 1,
                        gridWidth, gridWidth, gridWidth);
            }
            for(int colonne = 1; colonne < COLS; ++colonne){
                g.fillRoundRect((cellSize * colonne) - halfGridWidth, 0
                        , gridWidth, canvasHeight - 1,
                        gridWidth, gridWidth);
            }


            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(symbolStrokeWidth,
                    BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            for(int ligne = 0; ligne < ROWS; ++ligne){
                for(int colonne = 0; colonne < COLS; ++colonne){
                    int x1 = (colonne * cellSize) + cellPadding;
                    int y1 = (ligne * cellSize) + cellPadding;

                    if(board[ligne][colonne] == Token.CERCLE_ROUGE){
                        g2d.setColor(Color.RED);
                        g2d.drawOval(x1, y1, symbolSize, symbolSize);
                        g2d.fillOval(x1, y1, symbolSize, symbolSize);
                    } else
                        if(board[ligne][colonne] == Token.CERCLE_BLEU){
                            int x2 = (colonne * cellSize) + cellPadding;
                            g2d.setColor(Color.BLUE);
                            g2d.drawOval(x1, y1, symbolSize, symbolSize);
                            g2d.fillOval(x2, y1, symbolSize, symbolSize);
                        }
                }
            }
        }
    }

    public static void main(String[] args){

        //set test number. Change values between 0-2 to run different tests
        testNumber = 2;
        SwingUtilities.invokeLater(() -> {
            new Pha();
        });
    }

    //method used for testing only: load test data
    private static int[] loadtestData(Token[][] board) {

        switch (testNumber) {

            case 1:
                board[6][6] = Token.CERCLE_ROUGE; //origin and target
                board[6][7] = Token.CERCLE_ROUGE;
                board[6][8] = Token.CERCLE_BLEU;

                board[7][6] = Token.CERCLE_ROUGE;
                board[7][7] = Token.CERCLE_BLEU;
                board[7][8] = Token.CERCLE_BLEU;

                board[8][6] = Token.CERCLE_ROUGE;
                board[8][7] = Token.CERCLE_ROUGE;
                board[8][8] = Token.CERCLE_ROUGE;

                board[5][7] = Token.CERCLE_ROUGE;
                board[5][8] = Token.CERCLE_ROUGE;
                board[5][9] = Token.CERCLE_ROUGE;
                board[6][9] = Token.CERCLE_ROUGE;
                board[7][9] = Token.CERCLE_ROUGE;
                return new int[] {6,6};

            case 2:
                //line 3
                board[3][6] = Token.CERCLE_ROUGE;
                //line 4
                board[4][4] = Token.CERCLE_BLEU; //origin
                board[4][5] = Token.CERCLE_BLEU;
                board[4][6] = Token.CERCLE_BLEU;
                board[4][8] = Token.CERCLE_BLEU;
                //line5
                board[5][3] = Token.CERCLE_BLEU;
                board[5][5] = Token.CERCLE_ROUGE;
                board[5][7] = Token.CERCLE_BLEU;
                board[5][8] = Token.CERCLE_ROUGE;
                board[5][9] = Token.CERCLE_BLEU;
                //line 6
                board[6][2] = Token.CERCLE_BLEU;
                board[6][3] = Token.CERCLE_ROUGE;
                board[6][4] = Token.CERCLE_ROUGE;
                board[6][5] = Token.CERCLE_ROUGE;
                board[6][6] = Token.CERCLE_ROUGE;
                board[6][7] = Token.CERCLE_ROUGE;
                board[6][8] = Token.CERCLE_ROUGE;
                board[6][9] = Token.CERCLE_BLEU;
                //line 7
                board[7][3] = Token.CERCLE_BLEU;
                board[7][4] = Token.CERCLE_BLEU;
                board[7][5] = Token.CERCLE_BLEU;
                board[7][6] = Token.CERCLE_BLEU;
                board[7][7] = Token.CERCLE_ROUGE;
                board[7][8] = Token.CERCLE_BLEU;
                //line 8
                board[8][3] = Token.CERCLE_ROUGE;
                board[8][7] = Token.CERCLE_BLEU;
                board[8][8] = Token.CERCLE_ROUGE;
                board[8][9] = Token.CERCLE_BLEU;
                //line 9
                board[9][7] = Token.CERCLE_ROUGE;
                board[9][8] = Token.CERCLE_BLEU;
                board[9][9] = Token.CERCLE_ROUGE;
                //line 10
                board[10][8] = Token.CERCLE_ROUGE;
                board[10][9] = Token.CERCLE_ROUGE;
                return new int[] {4,4};

            case 0: default:
                    board[6][6] = Token.CERCLE_ROUGE;
                    board[6][7] = Token.CERCLE_ROUGE; //origin and target
                    board[6][8] = Token.CERCLE_BLEU;

                    board[7][6] = Token.CERCLE_ROUGE;
                    board[7][7] = Token.CERCLE_BLEU;
                    board[7][8] = Token.CERCLE_ROUGE;

                    board[8][6] = Token.CERCLE_ROUGE;
                    board[8][7] = Token.CERCLE_ROUGE;
                    board[8][8] = Token.CERCLE_ROUGE;

                    board[5][7] = Token.CERCLE_ROUGE;
                    board[5][8] = Token.CERCLE_ROUGE;
                    board[5][9] = Token.CERCLE_ROUGE;
                    board[6][9] = Token.CERCLE_ROUGE;
                    board[7][9] = Token.CERCLE_ROUGE;
                    return new int[] {6,7};
        }
    }
}

class CellsList extends ArrayList<int[]>{

    @Override  //override to check by the value of int[]
    public boolean contains(Object o) {

        for (int[] a : this) {
            if(Arrays.equals(a, (int[]) o)) {
                return true;
            }
        }

        return false;
    }
}