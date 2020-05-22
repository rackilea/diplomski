public static void main(final String[] args) {
    final int numberToCount = 7;

    final int[] x = new int[]{1,2,3,4,4,6,6,6,6,7,7,7,7,7,8,8,8,8,8,8};

    final int indexOfKnownOccurence = Arrays.binarySearch(x, numberToCount);
    if (indexOfKnownOccurence < 0) {
        System.out.println("No instances of the number found");
        return;
    }

    final int lowerBound = findIndexOfFirstOccurence(x, numberToCount, 0, indexOfKnownOccurence);

    final int upperBound = findIndexOfLastOccurence(x, numberToCount, indexOfKnownOccurence, x.length - 1);

    System.out.println("Lower bound: " + lowerBound);
    System.out.println("Upper bound: " + upperBound);
    System.out.println("Number of occurrences: " + (upperBound - lowerBound + 1));
}

//Binary search for start index
public static int findIndexOfFirstOccurence(final int[] x, final int numberToFind, final int startIndex, final int endIndex) {
    if (startIndex == endIndex) {
        return startIndex;
    } else if (x[startIndex] == numberToFind) {
        return startIndex;
    } else if (startIndex + 1 == endIndex) {
        return endIndex;
    }

    final int midIndex = startIndex + (int)Math.floor((endIndex - startIndex) / 2);

    if (x[midIndex] == numberToFind) {
        return findIndexOfFirstOccurence(x, numberToFind, startIndex, midIndex);
    } else {
        return findIndexOfFirstOccurence(x, numberToFind, midIndex, endIndex);
    }
}

//Binary search for end index
public static int findIndexOfLastOccurence(final int[] x, final int numberToFind, final int startIndex, final int endIndex) {
    if (startIndex == endIndex) {
        return endIndex;
    } else if (x[endIndex] == numberToFind) {
        return endIndex;
    } else if (startIndex + 1 == endIndex) {
        return startIndex;
    }

    final int midIndex = startIndex + (int)Math.floor((endIndex - startIndex) / 2);

    if (x[midIndex] == numberToFind) {
        return findIndexOfLastOccurence(x, numberToFind, midIndex, endIndex);
    } else {
        return findIndexOfLastOccurence(x, numberToFind, startIndex, midIndex);
    }
}