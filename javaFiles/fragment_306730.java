public class SomeClass {

    public int[][] gridArray; 

    private int N;

    public SomeClass(int N){
        this.N = N;
        this.gridArray = new int[N][N];
    }

    public boolean isValid(int i, int j){
        if (i < 0 || i >= N || j < 0 || j >= N){
            System.out.println(i + " and " + j + " and "+ N);
            throw new IndexOutOfBoundsException();
        } else{return true;}
    }

    public static void main(String[] args) {
        SomeClass instance = new SomeClass(5);
        instance.isValid(4,4);
    }
}