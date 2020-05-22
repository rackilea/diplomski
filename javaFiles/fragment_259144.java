long solutions = 0;
    for (Integer p : peter) {
        solutions += countLargerThan(colin, p);
    }

    ...

    private static int countLargerThan(List<Integer> colin, int p) {
        int count = 0;
        for (Integer c : colin) {
            if (p > c) {
                count++;
            }
        }
        return count;
    }