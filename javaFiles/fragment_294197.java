public class VersionComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        /* Handle nulls. */
        if (left == null) {
            if (right == null) {
                return 0;
            }
            return -1;
        } else if (right == null) {
            return 1;
        }
        /* Generate tokens */
        String[] lTokens = left.split("\\.");
        String[] rTokens = right.split("\\.");

        int len = Math.max(lTokens.length, rTokens.length);
        for (int i = 0; i < len; i++) {
            /* Check if both sides still have tokens */
            if (i < lTokens.length && i < rTokens.length) {
                int a = Integer.parseInt(lTokens[i]);
                int b = Integer.parseInt(rTokens[i]);

                if (a < b) {
                    return -1;
                } else if (a > b) {
                    return 1;
                }
            } else if (i < rTokens.length) {
                /* No more tokens on the left hand side */
                return -1;
            } else {
                /* No more tokens on the right hand side */
                return 1;
            }
        }
        return 0;
    }
}