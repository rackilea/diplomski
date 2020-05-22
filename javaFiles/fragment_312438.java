public class TestClass {
    static int TOTAL_SIZE = 5;
    static int CHUNK_SIZE = 3;
    static int[] wordArray = new int[TOTAL_SIZE];

    public static void main(String args[]) {
        for(int i = 0; i < TOTAL_SIZE; i++) {
            wordArray[i] = i;
        }

        List<Integer> newList = new ArrayList<>();
        int[] visitedIndexes = new int[TOTAL_SIZE];
        printAllValues(newList, visitedIndexes);
    }


    private static void printAllValues(List<Integer> newList, int[] visitedIndexes) {
        if(newList.size() == CHUNK_SIZE) {
            newList.stream().forEach(System.out::print);
            System.out.println(""); // new line
            return;
        }

        for (int i = 0; i < TOTAL_SIZE; i++) {
            if (visitedIndexes[i] != 1) {
                visitedIndexes[i] = 1;
                newList.add(wordArray[i]);
                printAllValues(newList, visitedIndexes);
                newList.remove((Integer) wordArray[i]);
                visitedIndexes[i] = 0;
            }
        }
    }
}