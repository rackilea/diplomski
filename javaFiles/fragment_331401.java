public class WordLookUp {
private List<String> original;
private List<String> mostOccur = new ArrayList<String>();
private List<Integer> count = new ArrayList<Integer>();


public WordLookUp(String file) throws Exception {
    try(Scanner reader = new Scanner(new File(file));){
        this.original = new ArrayList<String>();
        String token = " ";
        while (reader.hasNext()) { //reads file and stores it in string
            token = reader.next();
            this.original.add(token); //adds it to my arrayList
            findMostOccurringWords(token);
        }
    }
}

public void findMostOccurringWords(String token) {
    int counter = 0;
    String[] mostWords = token.split(" "); //storing read lines in mostWords arrayList
    try {
        for (int i = 0; i < mostWords.length; i++) {
            for(int j = 0; j < this.original.size(); j++) {
                if (original.get(j).equals(mostWords[i])) {
                    counter++; //increase counter
                }
            }
            if (mostOccur.contains(mostWords[i])) {
                count.set(mostOccur.indexOf(mostWords[i]),counter);
            }else {
                mostOccur.add(mostWords[i]);
                count.add(counter);
            }
        }
    } catch (ArrayIndexOutOfBoundsException ae) {
        System.out.println("Illegal index");
    }
}

public void count() {
    for (int i = 0; i < mostOccur.size(); i++) {
        System.out.println("Word: " + mostOccur.get(i) + " count: " + count.get(i));
    }
}
}

public class Main {

public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    WordLookUp wL = new WordLookUp("F:\\gc.log");

    wL.count();

}