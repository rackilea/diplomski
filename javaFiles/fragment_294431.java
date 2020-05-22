public class IntPermutationsGenerator implements Iterator<int[]> {
    final int[] permutation;
    private boolean onFirst = true;
    private final int size;

    public IntPermutationsGenerator(int dimension) {
        permutation = new int[dimension];
        for (int i = 0; i < dimension; ++i)
            permutation[i] = i;
        this.size = dimension;
    }


    @Override
    public boolean hasNext() {
        return !isLast() || onFirst;
    }

    private boolean isLast() {
        for (int i = 0; i < size; i++)
            if (permutation[i] != size - 1 - i)
                return false;
        return true;
    }


    @Override
    public int[] next() {
        if (onFirst) {
            onFirst = false;
            return permutation;
        }
        final int end = size - 1;
        int p = end, low, high, med, s;
        while ((p > 0) && (permutation[p] < permutation[p - 1]))
            p--;
        if (p > 0) //if p==0 then it's the last one
        {
            s = permutation[p - 1];
            if (permutation[end] > s)
                low = end;
            else {
                high = end;
                low = p;
                while (high > low + 1) {
                    med = (high + low) >> 1;
                    if (permutation[med] < s)
                        high = med;
                    else
                        low = med;
                }
            }
            permutation[p - 1] = permutation[low];
            permutation[low] = s;
        }
        high = end;
        while (high > p) {
            med = permutation[high];
            permutation[high] = permutation[p];
            permutation[p] = med;
            p++;
            high--;
        }
        return permutation;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}