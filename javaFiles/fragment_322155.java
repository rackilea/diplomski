public class Duplicate {

    private String sentence;
    private String store[];
    private int countLines = 0;

    public String getString(Scanner s) {
        sentence = s.nextLine();
        countLines++;
        return sentence;
    }

    public void count() {
        store = sentence.split(" ");
        System.out.print(store.length + " ");
    }

    public void countLine(Scanner s) {
        while (s.hasNextLine()) {
            String line = s.nextLine();

            //verify if line is not empty
            if (!line.isEmpty())
                countLines +=1;
        }

        System.out.print(countLines);
    }
}