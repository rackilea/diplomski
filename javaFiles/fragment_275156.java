class Combinations<T> implements Iterator<List<T>> {

    final List<List<T>> elements;
    final int[] indices;

    public Combinations(List<List<T>> elements) {
        this.elements = elements;
        this.indices = new int[elements.size()];
    }

    @Override
    public boolean hasNext() {
        // has first index not yet reached max position?
        return indices[0] < elements.get(0).size();
    }

    @Override
    public List<T> next() {
        // get next
        List<T> result = new ArrayList<>(indices.length);
        for (int i = 0; i < indices.length; i++) {
            result.add(elements.get(i).get(indices[i]));
        }
        // increase indices
        for (int i = indices.length - 1; i >= 0; i--) {
            indices[i]++;
            if (indices[i] >= elements.get(i).size() && i > 0) {
                indices[i] %= elements.get(i).size();
            } else {
                break;
            }
        }
        return result;
    }
}