public int longestConsecutiveAfter(int[] num) {
    // write you code here
    if (num == null || num.length == 0) {
        return 0;
    }



    HashSet<Integer> hash = new HashSet<Integer>();
    int count = 1, currentSequence = 1;

    for (Integer i : num) {
        hash.add(i);
    }

    if (hash.size() == 1) return 1; //all elements are the same

    int i = 0;
    while (hash.size() > 0) {
        int elem = num[i++];
        if (hash.remove(elem)) {
            int lcursor = elem;
            int rcursor = elem;
            currentSequence = 1;

            while (hash.remove(++rcursor)) {
                currentSequence++;
            }

            while (hash.remove(--lcursor)) {
                currentSequence++;
            }

            count = Math.max(count, currentSequence);
        }
    }

    return count;
}

public static int longestConsecutiveN(int[] num) {
    // write you code here
    if (num == null || num.length == 0) {
        return 0;
    }

    HashMap<Integer, Integer> hash = new HashMap<>();
    for (Integer i : num) {
        hash.put(i, 1);
    }

    Integer max = 1;
    Integer curSeqLength = null;
    for (Integer i: num) {
        if ((curSeqLength = hash.get(i)) != null) {
            Integer mergeSeqLength = null;
            while ((mergeSeqLength = hash.remove(i + curSeqLength)) != null) {
                curSeqLength = curSeqLength + mergeSeqLength;
                hash.put(i, curSeqLength);
            }
            if (curSeqLength > max) max = curSeqLength;
        }
    }

    return max;
}

public int longestConsecutiveTree(int[] num) {
    // write you code here
    if (num == null || num.length == 0) {
        return 0;
    }

    Set<Integer> hash = new TreeSet<>();
    int count = 1, currentSequence = 1;

    for (int i : num) {
        hash.add(i);
    }

    if (hash.size() == 1) return 1; //all elements are the same

    Iterator<Integer> iterator = hash.iterator();
    int elem = iterator.next();
    while (iterator.hasNext()) {
        int cursor = iterator.next();
        if (cursor - elem == 1) {
            currentSequence++;
        } else {
            count = Math.max(count, currentSequence);
            currentSequence = 1;
        }
        elem = cursor;
    }

    count = Math.max(count, currentSequence);
    return count;
}



public int longestConsecutiveSorted(int[] num) {
    // write you code here
    if (num == null || num.length == 0) {
        return 0;
    }

    if (num.length == 1) {
        return 1;
    }


    int count = 1, currentSequence = 1;

    int[] copy = new int[num.length];
    System.arraycopy(num, 0, copy, 0, num.length);
    Arrays.sort(copy);
    int i = 1;
    while (++i < copy.length) {
        int diff = copy[i] - copy[i - 1];
        if (diff == 1) {
            currentSequence++;
        } else if (diff != 0) {
            count = Math.max(count, currentSequence);
            currentSequence = 1;
        }
    }

    count = Math.max(count, currentSequence);
    return count;
}