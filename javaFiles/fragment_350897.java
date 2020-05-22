public class Test {

    public static void main(final String[] args) {
        HashMap<Integer, Integer> testHashes = new HashMap<Integer, Integer>();
        int compHand = 10;
        populateHash(testHashes);

        int iter = -1;
        int[] indexArray = new int[(testHashes.size())];
        HashMap<Integer, Integer> bannedValues = new HashMap<Integer, Integer>();

        for (int i = 1; i <= testHashes.size(); i++) {
            if (!isBannedIndex(bannedValues, i)) {
                if (compHand == testHashes.get(i)) {
                    indexArray[++iter] = i;
                    banIndex(bannedValues, i);
                } else {
                    for (int j = i + 1; j <= testHashes.size(); j++) {
                        if (!isBannedIndex(bannedValues, j)) {
                            if(compHand == testHashes.get(i) + testHashes.get(j)) {
                                indexArray[++iter] = i;
                                indexArray[++iter] = j;
                                banIndex(bannedValues, i);
                                banIndex(bannedValues, j);
                                break;
                            } else {
                                if (compHand == testHashes.get(j)) {
                                    indexArray[++iter] = j;
                                    banIndex(bannedValues, j);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (iter > -1) {
            System.out.println("iter > -1");
            for (int i = 0; i < indexArray.length; i++) {
                System.out.println(indexArray[i]);
            }
        }
    }

    private static boolean isBannedIndex(
            final HashMap<Integer, Integer> banned, final int index) {

        return !banned.isEmpty() && banned.values().contains(index);
    }

    private static void banIndex(final HashMap<Integer, Integer> banned,
            final int index) {

        if (banned != null)
            banned.put(banned.size() + 1, index);
    }

    private static void populateHash(final HashMap<Integer, Integer> hash) {
        // TODO Auto-generated method stub
        hash.put(1, 1);
        hash.put(2, 3);
        hash.put(3, 1);
        hash.put(4, 1);
        hash.put(5, 10);
        hash.put(6, 10);
        hash.put(7, 10);
        /*
         * hash.put(8, 7); hash.put(9, 1); hash.put(10, 10); hash.put(11, 5);
         * hash.put(12, 8); hash.put(13, 1); hash.put(14, 1); hash.put(15, 6);
         * hash.put(16, 1); hash.put(17, 1); hash.put(18, 2);
         */

    }
}