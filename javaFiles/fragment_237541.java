private class RangeIter implements Iterator<Integer> {

    private int currentIndex = 0;

    public RangeIter ()
    {
        currentIndex = 0;
        while (currentIndex < size && !elementFlags[currentIndex])
            currentIndex++;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < size;  
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No elements more!");
        }
        Integer element = currentIndex;
        while (currentIndex < size && !elementFlags[currentIndex]) {
            currentIndex++;
        }
        return element + lowerBound;
    }

}