public class Main {
    public static void main(String[] args) {
        String[] lines = {
                "Once upon a time in a galaxy far, far away, there lived\n",
                "this _idiot_ trying to _mark up_ a few lines of\n",
                "marked down text using yet another _language_.\n" };

        for(String line : lines) {
            String output = line.replaceAll("_(.+?)_", "<em>$1</em>");

            System.out.print(output);
        }
    }
}