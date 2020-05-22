import java.util.Scanner;

    public class WCount {

        public static void main(String[] args) {

            Scanner stdin = new Scanner(System.in);

            int[] wordCount = new int[1000];
            String[] wordList = new String[1000];

            int j = 0;
            while (stdin.hasNextLine()) {
                String s = stdin.nextLine();
                String[] words = s.split("\\W+");

                for (String word : words) {

                    int listIndex = -1;
                    for (int i = 0; i < wordList.length; i++) {
                        if (word.equals(wordList[i])) {
                            listIndex = i;
                        }
                    }

                    if (listIndex > -1) {
                        wordCount[listIndex]++;
                    } else {
                        wordList[j] = word;
                        wordCount[j]++;
                        j++;
                    }

                }

                for (int i = 0; i < j; i++) {
                    System.out.println("the word: " + wordList[i] + " occured " + wordCount[i] + " time(s).");
                }
            }
        }

    }