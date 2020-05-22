public class Tester {
    public static void main(String[] args) {
        String text = "This is a random sentence. In this example, we will be replacing some of the words with blank spaces.";
        String[] array = text.split(" ");
        int randomIndex = (int)(Math.random() * ((array.length - 1) + 1));
        int minBlankSize = 1;
        int maxBlankSize = 4;
        int blankSize = minBlankSize + (int)(Math.random() * ((maxBlankSize - minBlankSize) + 1));

        for(int i = 0; i <= blankSize && randomIndex + i != array.length; i++) {
            array[randomIndex + i] = "____";
        }

        for(String word : array) {
            System.out.print(" " + word);
        }
    }
}