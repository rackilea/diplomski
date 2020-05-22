private class ResultIterator implements Iterator<Result> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Result next() {
            return results.get(index++);
        }
    }