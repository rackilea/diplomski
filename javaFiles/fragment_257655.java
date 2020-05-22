import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String args[]) throws FileNotFoundException {

//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("TABLE.csv"));

        Map<Pair, List<String>> output = new HashMap<Pair, List<String>>();

        while (scanner.hasNext()) {
            String col1 = scanner.next();
            String col2 = scanner.next();
            String value = scanner.next();

            Pair pair = new Pair(col1, col2);

            if (output.containsKey(pair)) {
                output.get(pair).add(value);
            } else {
                output.put(pair, new LinkedList<String>());
                output.get(pair).add(value);
            }

        }

        System.out.println(output.toString());

    }

}

class Pair {

    private String col1;

    @Override
    public String toString() {
        return "Pair{" +
                "col1='" + col1 + '\'' +
                ", col2='" + col2 + '\'' +
                '}';
    }

    public Pair(String col1, String col2) {
        this.col1 = col1;
        this.col2 = col2;
    }

    private String col2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (col1 != null ? !col1.equals(pair.col1) : pair.col1 != null) return false;
        return col2 != null ? col2.equals(pair.col2) : pair.col2 == null;

    }

    @Override
    public int hashCode() {
        int result = col1 != null ? col1.hashCode() : 0;
        result = 31 * result + (col2 != null ? col2.hashCode() : 0);
        return result;
    }
}