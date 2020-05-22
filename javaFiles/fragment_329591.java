public static int KnapSack(int capacity, Item[] items, int numItems, ArrayList<Integer> taken) {
    if (numItems == 0 || capacity == 0)
        return 0;
    if (items[numItems-1].weight > capacity)
        return KnapSack(capacity, items, numItems-1, taken);
    else {
        final int preTookSize = taken.size();
        final int took = items[numItems-1].value + KnapSack(capacity - items[numItems-1].weight, items, numItems-1, taken);

        final int preLeftSize = taken.size();
        final int left = KnapSack(capacity, items, numItems-1, taken);

        if (took > left) {
            if (taken.size() > preLeftSize)
                taken.removeRange(preLeftSize, taken.size());
            taken.add(Integer.valueOf(numItems - 1));
            return took;
        }
        else {
            if (preLeftSize > preTookSize)
                taken.removeRange(preTookSize, preLeftSize);
            return left;
        }
    }     
}