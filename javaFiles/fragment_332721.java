public class Perm {
    private static byte[] sequenceToMatch;
    private static byte[] startSequence;    
    private static byte[] endingSequence;        
    private static final int SEQUENCE_LENGTH = 64;

    public static void main(String... args) {
        final int N = 3;

        startSequence = readSequence(args[0]);
        endingSequence = readSequence(args[1]);
        sequenceToMatch = readSequence(args[2]);                

        permutations();
    }    

    private static boolean sequencesMatch(byte[] s1, byte[] s2) {
        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] readSequence(String argument) {
        String[] sBytes = argument.split(",");
        byte[] bytes = new byte[SEQUENCE_LENGTH];
        int i = 0;
        for (String sByte : sBytes) {
            bytes[i++] = Byte.parseByte(sByte, 10);
        }
        return bytes;
    }

    private static void swap(byte[] elements, int i, int j) {
        byte temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    /**
     * Reverses the elements of an array (in place) from the start index to the end index 
     */
    private static void reverse(byte[] array, int startIndex, int endIndex) {
        int size = endIndex + 1 - startIndex;
        int limit = startIndex + size / 2;
        for (int i = startIndex; i < limit; i++) {
            // swap(array, i, startIndex + (size - 1 - (i - startIndex)));
            swap(array, i, 2 * startIndex + size - 1 - i);
        }
    }

    /**
     * Implements the Knuth's L-Algorithm permutation algorithm 
     * modifying the collection in place
     */
    private static void permutations() {
        byte[] sequence = startSequence;

        if (sequencesMatch(sequence, sequenceToMatch)) {
            System.out.println("Solution found!");
            return;
        }

        // For every possible permutation 
        while (!sequencesMatch(sequence, endingSequence)) {

            // Iterate the array from right to left in search 
            // of the first couple of elements that are in ascending order
            for (int i = SEQUENCE_LENGTH - 1; i >= 1; i--) {
                // If the elements i and i - 1 are in ascending order
                if (sequence[i - 1] < sequence[i]) {
                    // Then the index "i - 1" becomes our pivot index 
                    int pivotIndex = i - 1;

                    // Scan the elements at the right of the pivot (again, from right to left)
                    // in search of the first element that is bigger
                    // than the pivot and, if found, swap it
                    for (int j = SEQUENCE_LENGTH - 1; j > pivotIndex; j--) {
                        if (sequence[j] > sequence[pivotIndex]) {
                            swap(sequence, j, pivotIndex);
                            break;
                        }
                    }

                    // Now reverse the elements from the right of the pivot index
                    // (this nice touch to the algorithm avoids the recursion)
                    reverse(sequence, pivotIndex + 1, SEQUENCE_LENGTH - 1);
                    break;
                }
            }

            if (sequencesMatch(sequence, sequenceToMatch)) {
                System.out.println("Solution found!");
                return;
            }
        }
    }
}