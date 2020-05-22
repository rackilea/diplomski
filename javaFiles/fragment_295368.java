public class AlphaSwap {
static int start = 0;
public static void main(String[] args) {
    String input[] = { "a", "b", "c", "_" };
   // int start = 0;
    int end = input.length - 1;

    AlphaSwap alphaSwap = new AlphaSwap();
    alphaSwap.swapFirst(input, start, end);

    //swapLast(input, start, end);

    for (String string : input) {
        System.out.println(string);
    }
    System.out.println(start);
    System.out.println(end);
}

private void swapFirst(String[] input, int i, int j) {
    String temp = input[i];
    input[i] = input[j];
    input[j] = temp;
    start++;
}
}