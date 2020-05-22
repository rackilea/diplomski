import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Cell c = new Cell();
        int[][] cell = c.rawCell();
        System.out.println("Arrays.toString:");
        System.out.println(Arrays.toString(cell)); // ugly, ugly object addresses

        System.out.println("\n\n");

        System.out.println("Arrays.deepToString:");
        System.out.println(Arrays.deepToString(cell)); // well this is basically alright, but it's all in one line

        System.out.println("\n\n");

        //now there's a pretty matrix! look at you, all filled with numbers
        System.out.println("Going down the levels by hand:");
        for(int i = 0; i < cell.length; i++) {
            System.out.print("[");
            for(int j = 0; j < cell[i].length; j++) {
                System.out.print(cell[i][j]);
                if(j != cell[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

        System.out.println("\n\n\n\n\n\n\n\n");

        // if you're dead set on using Arrays.toString(),
        // you'll have to go down to the very lowest level by hand
        System.out.println("Arrays.toString for each one-dimensional array:");
        for(int i = 0; i < cell.length; i++) {
            System.out.println(Arrays.toString(cell[i]));
        }
    }
}