private static List<Integer> list = new ArrayList<>();
private static int input;
private static int counter = 1;

public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    System.out.print("Enter a series of numbers ending with 0: ");

    while (true) {
        input = scan.nextInt();
        if (input == 0) {
            break;  // don't add 0 to the list
        }
        list.add(input);
    }

    int index = 0;              // the current beginning of the sequence
    int currNum;                // the current candidate for the sequence num
    int theNum = list.get(0);   // keep track of the num with the longest sequence
    int theCount = 0;           // keep track of the count (length) of the longest sequence
    int theIndex = 0;           // keep track of where the sequence began
    for (int i = 1; i < list.size(); i++) {
        currNum = list.get(i-1);
        if (list.get(i).equals(currNum)) {
            if (counter == 1) {
                // note that a sequence is beginning, and its location
                index = i - 1;
            }
            counter++;
            if (counter > theCount) {
                // check if you've found a longer sequence
                theCount = counter;
                theNum = currNum;
                theIndex = index;
            }
        } else {
            // sequence broken, count from scratch
            counter = 1;
        }
    }

    System.out.println("The longest same number sequence starts at index "
            + theIndex + " with " + theCount + " values of " + theNum);

    Collections.sort(list);
    System.out.println("\tThe sorted series of numbers is : " + list);

}