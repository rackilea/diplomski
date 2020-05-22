public class GetWords {

    public static void main(String[] args) {
        String inputOCR = "This contains some address random words used to test License should not be picked up";
        String[] list = inputOCR.split(" "); 

        int startPosition = getIndexOfWordInArray(list, "address") + 1;
        int endPosition = getIndexOfWordInArray(list, "license");

        for (int i = startPosition; i < endPosition; i++) {
            System.out.println(list[i]);
        }
    }

    public static int getIndexOfWordInArray(String[] list, String word) {
        int index = -1;

        for (int i = 0; i < list.length; i++) {
            if (list[i].equalsIgnoreCase(word)) {
                index = i;
                break;
            }
        }

        return index;
    }
}