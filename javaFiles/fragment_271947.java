import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;   
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import src.tests.Cell.CellState;

public class Maze extends Application{

    final int[][] level = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1}};

    //represents moving in 4 directions
    private final int[][] directions = {{1,0},{-1,0}, {0,1}, {0,-1}}; //down, up, right, left
    private final Cell[][] cells = new Cell[level.length][level[0].length];
    private final GridPane buttonGrid = new GridPane();
    private BreadthFirst algo;

    //Single Thread Executor guarantees that task (searches) do not run concurrently
    final ExecutorService exService = Executors.newSingleThreadExecutor();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        GridPane mazeGrid = new GridPane();
        Scene maze = new Scene(mazeGrid, 700, 700);          
        maze.getStylesheets().add(getClass().
                             getResource("Main.css").toExternalForm());
        makeBlankButton();
        mazeGrid.getChildren().add(buttonGrid);
        window.setScene(maze);
        window.show();
        solve();
    }

    void solve(){
        algo = new BreadthFirst(cells[5][5]) ;
        exService.execute(()->  algo.solve(cells[1][1]));
    }

    void reSolve(){
        stopSolve();
        resetCellsState();
        solve();
    }

    private void stopSolve(){   
        if(algo != null) {
            algo.stop();
        }
    }

    private void resetCellsState() {
        for(int row = 0; row < level.length; row++){
            for(int column = 0; column < level[0].length; column++){
                if( cells[row][column].getState() != CellState.WALL) {
                    cells[row][column].setState(CellState.IDLE);
                }
            }
        }
    }

    public void makeBlankButton(){

        //listen to cell state changes. If cell changed from or to WALL restart solve
        ChangeListener<CellState> listener = (obs , oldValue, newValue)->{
            if(oldValue == CellState.WALL || newValue == CellState.WALL) {
                reSolve();
            }
        };

        for(int row = 0; row < level.length; row++){
            for(int column = 0; column < level[0].length; column++){
                Cell cell = new Cell(row, column);
                GridPane.setConstraints(cell, column, row);
                if (level[row][column] == 1){
                    cell.setId("button-array-clicked");
                    cell.setState(CellState.WALL);
                } else if (level[row][column] == 0) {
                    cell.setId("button-array-blank");
                }
                buttonGrid.getChildren().add(cell);
                GridPane.setConstraints(buttonGrid, 0, 1);

                if (row == 3){
                    if (column == 0){
                        cell.setId("button-start");
                    } else if(column == 6){
                        cell.setId("button-end");
                    }
                }
                cell.addStateListener(listener);
                cells[row][column] = cell;
            }
        }
    }

    private List<Cell> getNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<>();
        int row = cell.getRow(), col = cell.getCol();
        for(int[] dir : directions){
            int newRow = row + dir[0] ; int newCol = col + dir[1];
            if(isValidAddress(newRow, newCol)) {
                neighbors.add(cells[newRow][newCol]);
            }
        }
        return neighbors;
    }

    private boolean isValidAddress(int row, int col) {  
        if(row < 0 || col < 0) return false;
        if(row >= level.length || col >= level[row].length) return false;
        return true;
    }

    public static void main(String[] args){launch(args);}

    class BreadthFirst {

        private static final long DELAY = 1000;
        private final LinkedList<Cell> path;
        private final Cell target;
        private volatile boolean isStopped;

        public BreadthFirst(Cell target) {
            this.target = target;
            path = new LinkedList<>();
            isStopped = false;
        };

        public boolean solve(Cell cell) {
            if(cell == null || isStopped) return false;

            // queue holds a nodes collections. each collection represents the path through
            //which a cell has been reached, the cell being the last element in the collection
            final Queue<List<Cell>> queue = new LinkedList<>(); //initialize queue

            //a collection to hold the path through which a cell has been reached
            //the cell it self is the last element in that collection
            List<Cell> pathToCell = new ArrayList<>();
            pathToCell.add(cell);

            //queue does not hold a cell, but rather the whole path to a cell
            //where the cell is stored as the last element
            queue.add(pathToCell);

            while (! queue.isEmpty() && ! isStopped) {

                pathToCell = queue.remove();
                //get cell (last element) from queue
                cell = pathToCell.get(pathToCell.size()-1);
                if(cell == null) return false;

                //skip if cell is wall, or is/was explored or in path
                if( cell.getState() != CellState.IDLE ) { continue; }

                setCellState(cell, CellState.IS_EXPLORED);

                addToPath(pathToCell);

                Wait.millis(DELAY);

                if(isSolved(cell))  return true;

                List<Cell> nb = getNeighbors(cell);
                Collections.shuffle(nb);

                //loop over neighbors
                for(final Cell nextCell : nb){

                    if(isStopped)   return false;
                    if(nextCell.getState() == CellState.WALL) { continue; }

                    final List<Cell> pathToNextCell = new ArrayList<>(pathToCell);
                    pathToNextCell.add(nextCell);
                    queue.add(pathToNextCell); //add collection to the queue
                }

                Collections.reverse(pathToCell);
                for(final Cell c : pathToCell) {
                    backTrack(c);
                }
            }
            return false;
        }

        private void setCellState(Cell cell, CellState state) {
            cell.setState(state);
        }

        /**
         * Append collection to path
         */
        private void addToPath(Collection<Cell> pathToCell) {

            for(Cell c : pathToCell) {
                if(isStopped)
                    return;
                addToPath(c);
            }
        }

        /**
         * Append Cell to path
         */
        private void addToPath(Cell node) {
            path.push(node);
            setCellState(node, CellState.PATH);
        }

        /**
         *Is maze solved
         */
        private boolean isSolved(Cell cell) {
            return cell.equals(target);
        }

        private void backTrack(Cell cell) {

            //no backtracking if back to origin
            if(path.size()<=1 || isStopped) return ;

            setCellState(cell, CellState.WAS_EXPLORED);

            //remove from stack
            if( path.peek().equals(cell)) {
                path.pop();
                return;
            }

            throw new IllegalStateException(cell+" isn't at the top of the stack");
        }

        void stop(){
            isStopped = true;
        }
    }
}

class Cell extends Button{

    private final SimpleObjectProperty<CellState> stateProperty
    = new SimpleObjectProperty<>(CellState.IDLE);
    private final int row, col;

    Cell(int row, int col){
        this.row = row; this.col = col;
        setOnAction(e -> toggleState());
    }

    public enum CellState {
        WALL  ("black"),
        IDLE  ("white") ,      //No activity is or was performed on node
        IS_EXPLORED ("blue"),  //node is evaluated by path finder
        WAS_EXPLORED ("grey"), //node was evaluated by path finder
        PATH ("green");        // node was evaluated by path finder and added to path

        public String color;
        CellState(String color) {this.color = color;}
    }

    void toggleState(){
        setState(getState() == CellState. WALL ?  CellState. IDLE : CellState. WALL );
    }

    void setState(CellState state){
        stateProperty.set(state);
        setStyle("-fx-background-color:" + state.color);
    }

    void addStateListener(ChangeListener<CellState> listener) {
        stateProperty.addListener(listener);
    }

    @Override
    public String toString() {
        return  getState()+" at "+ getRow() +" - " + getCol() ;
    }

    @Override
    public boolean equals(Object cell) {

        if (cell == null || !(cell instanceof Cell))
            return false;

        return ((Cell) cell).getRow() == row  &&  ((Cell) cell).getCol() == col;
    }

    @Override
    public int hashCode() {
        return  31*(row+1) + 17*(col+1);
    }

    int getRow() {  return row; }
    int getCol() {  return col;}
    CellState getState() {return stateProperty.get();}
}

class Wait {

    public static void millis(final long millis) {

        try {
            TimeUnit.MILLISECONDS.sleep(millis);

        } catch (final InterruptedException ex) {ex.printStackTrace();}
    }
}