import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {

    public static void BFS(Node root, Node goal) throws InterruptedException{
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>(); //**use to flow which nodes were tested
        queue.add(root);
        while(queue.size()>0){
            Node temp = queue.poll();
            if (temp.equals(goal)) {
                goal.setParent(temp.getParent());
                break;
            }
            else{
                List<Node> successor = temp.returnSuccessor();
                for(int i=0; i< successor.size(); i++){
                    //** made redundant by using visited boolean check = root.checkTree(successor.get(i));
                    Node node = successor.get(i);
                    if (visited.add(node)){ //** successful add indicates it was not visited before
                        queue.add(node);
                        temp.addChild(node);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {

        int[][] initialState = { {0,1}, {2,3}, {4,5} };
        int[][] goalState = {{3,4}, {5,0}, {1,2}};

        Node root = new Node(new State(initialState));
        Node goal = new Node(new State(goalState));
        BFS(root,goal);

        if(goal.getParent() ==  null){
            System.out.println("There is no such a way to go from the initial state to the goal state");
        }
        else{
            ArrayList<Node> listSteps = new ArrayList<>();
            while(goal != null){
                listSteps.add(goal);
                goal = goal.getParent();
            }
            for (int i=listSteps.size()-1; i>=0; i--){
                System.out.println(listSteps.get(i));
            }
            int numSteps = listSteps.size()-1;
            System.out.println("Number of steps: " + numSteps);
        }
    }
}

class State {
    private int data[][];

    public int[][] getData() {  return data;}

    public void setData(int[][] data) { this.data = data;   }
    public void swap(int row1, int col1, int row2, int col2){
        int temp = data[row1][col1];
        data[row1][col1] = data[row2][col2];
        data[row2][col2] = temp;
    }

    public State copyState() { //**simpler version of
        int i = 0;
        int[][] temp = new int[data.length][];
        for (int[] row : data) {
            temp[i++] = Arrays.copyOf(row, row.length); //**simpler way to copy array
        }
        return new State(temp);
    }

    public State(int[][] data) {
        super();
        this.data = data;
    }
}

class Node {
    private State state;
    private Node parent;
    private ArrayList<Node> children;

    public Node(State state){
        this.state = state;
        parent = null;
        children = new ArrayList<>();
    }

    public State getState() {   return state; }
    public void setState(State state) { this.state = state; }
    public Node getParent() { return parent;}
    public void setParent(Node parent) { this.parent = parent;  }
    public ArrayList<Node> getChildren() {  return children;    }
    public void addChild(Node node){
        node.setParent(this);
        children.add(node);
    }

    public List<Node> returnSuccessor(){
        List<Node> result = new ArrayList<>();
        int[][] matrix = getState().getData();
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                   /* need to check possible move for ALL nodes
                    * if ( matrix[i][j] == 0) {
                    rowX = i;
                    colX = j;
                   }*/

                    if( (j-1) >= 0 ){
                        State temp = getState().copyState();
                        temp.swap(i, j, i, j-1);
                        Node left = new Node(temp);
                        result.add(left);
                    }
                    if ( (j+1) < col ){
                        State temp = getState().copyState();
                        temp.swap(i, j, i, j+1);
                        Node right = new Node(temp);
                        result.add(right);
                    }
                    if ( (i-1) >= 0 ){
                        State temp = getState().copyState();
                        temp.swap(i, j, i-1, j);
                        Node top = new Node(temp);
                        result.add(top);
                    }
                    if ( (i+1) < row ){
                        State temp = getState().copyState();
                        temp.swap(i, j, i+1, j);
                        Node down = new Node(temp);
                        result.add(down);
                    }
            }
        }
        return result;
    }

    //override toString rather than creating
    @Override
    public String toString(){
        return Arrays.deepToString(getState().getData());
    }

    //**override equals rather than creating your own equal
    @Override
    public boolean equals(Object node){

           if (node == this) { return true; }
           if (node == null) { return false;}
           if (!(node instanceof Node)) {return false; }
        return Arrays.deepEquals(getState().getData(), ((Node)node).getState().getData());
    }

    //** override hashCode so each Node has a unique one
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}