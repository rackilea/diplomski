public Iterator<Type> iterator() {
    return new Iterator<Type>() {
        private int currentRow = 0;
        private int currentColumn = 0;

        public boolean hasNext() {
            if (currentRow + 1 == array.length) {
                return currentColumn < array[currentRow].length;
            }
            return currentRow < array.length;
        }

        public Type next() {
            if (currentColumn == array[currentRow].length) {
                currentColumn = 0;
                currentRow++;
            }
            if (currentRow == array.length -1 && currentColumn == array[currentRow].length - 1) {
                throw new NoSuchElementException();
            }
            return array[currentRow][currentColumn++];
        }
    };
}