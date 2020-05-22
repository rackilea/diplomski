public class Test {

public static int findLastOccuranceRecursive(int[] input, int key, int... optionalIndex) {
    if (optionalIndex.length == 0) {
        optionalIndex = new int[] { input.length - 1 };
    } else if (optionalIndex.length != 1) {
        throw new IllegalArgumentException("size of optionalIndex must be 0 or 1");
    }

    if (optionalIndex[0] == 0) {
        return -1;
    }
    if (input[optionalIndex[0]] == key) {
        return optionalIndex[0];
    } else {
        optionalIndex[0]--;
        return findLastOccuranceRecursive(input, key, optionalIndex);
    }
}

public static int findLastOccuranceIterative(int[] items, int key) {
    for (int i = items.length - 1; i >= 0; i--) {
        if (items[i] == key) {
            return i;
        }
    }
    return -1;
}

public static void main(String[] args) {
    int[] input = { 1, 1, 1, 2, 1, 2, 1, 1 };
    int testRecursive = findLastOccuranceRecursive(input, 2);
    int testIterative = findLastOccuranceIterative(input, 2);
    System.out.println("testRecursive: " + testRecursive + " testIterative: " + testIterative);
}
}