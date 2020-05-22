public class Capitalize {

    public static String capitalize(String s) {
        if (s.length() == 0) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] words = line.split("\\s");
            for (String s : words) {
                StdOut.print(capitalize(s) + " ");
            }
            StdOut.println();
        }
    }

}