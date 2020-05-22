LinkedList<int[]> ret = new LinkedList<int[]>();
int endMask = 1 << numberOfBits;
for (int mask = 0 ; mask != endMask ; mask++) {
    int[] combo = new int[numberOfBits];
    for (int i = 0 ; i != numberOfBits ; i++) {
        combo[i] = ((mask & (1 << i)) != 0) ? 1 : 0;
    }
    ret.add(combo);
}