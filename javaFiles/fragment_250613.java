public class Board {
    public static void main(String[] args) {
    StringBuilder s= new StringBuilder();
    for( int r = 0; r < 10; r++) {
        for( int c = 0; c < 10; c++) {
            s.append("- ");
        }
        s.append("\n");
    }
    System.out.print(s);
    }
}