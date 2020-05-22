class Combination {
        int indexA, indexB, valueA, valueB;

        public Combination(int[] array, int indexA, int indexB) {
            this.indexA = indexA;
            this.indexB = indexB;
            this.valueA = array[indexA];
            this.valueB = array[indexB];
        }

        public int getDistance() { ... }
        public int getHigh() { ... }
        public int getLow() { ... }
        public int getHighIndex() { ... }
        public int getLowIndex() { ... }
    }