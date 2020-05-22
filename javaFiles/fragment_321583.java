int[] ranks = new int[arr.length];
    ranks[pairs[0].index] = 1;
    for (int i = 1; i < pairs.length; ++i) {
        if (pairs[i].value == pairs[i - 1].value) {
            ranks[pairs[i].index] = ranks[pairs[i - 1].index];
        } else {
            ranks[pairs[i].index] = i + 1;
        }
    }