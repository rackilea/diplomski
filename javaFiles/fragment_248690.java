int mode = -1;
    if (diffs.size() != 0) {
        int[] count = new int[Collections.max(diffs) + 1];
        for (int j = 0; j < diffs.size(); j++) {
            count[diffs.get(j)]++;
        }
        int index = count.length - 1;
        for (int j = count.length - 2; j >= 0; j--) {
            if (count[j] > count[index]) {
                index = j;
                mode = j;
            } else if (count[j] == count[index]) {
                mode = -1;
                // don't break, since we may still find j such that count[j] > count[index]
            }
        }
    }