public class FileSplitter {

    public static void main(String[] args) throws IOException {
        File file = new File("input_file.txt");
        LinkedList<String> words = new LinkedList<String>();
        int i = 0;

        Files.lines(file.toPath()).
        forEachOrdered(line -> words.
                addAll(Arrays.asList(line.split(" "))));

        for(String word:words){
            if(word.trim().length() > 0){
                System.out.print(word.trim() + " ");
                if(i++ >= 3){
                    System.out.println();
                    i = 0;
                }
            }
        }
    }
}