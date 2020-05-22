class Pair implements Comparable<Pair> {
    final int index;
    final int value;

    Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int compareTo(Pair oth) {
        if (value < oth.value) return -1;
        else if (value > oth.value) return 1;
        else if (index < oth.index) return -1;
        else if (index > oth.index) return 1;
        else return 0;
    }
}

final ArrayList<Pair> list = new ArrayList<Pair>();

for (int k = 0; k < array.length; ++k) {
    list.add(new Pair(k, array[k]);
}

Arrays.sort(list);