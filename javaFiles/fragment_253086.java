private static Iterator<Integer> getIt(){
    return new Iterator<Integer>() {

        private int nr = 0;

        @Override
        public boolean hasNext() {
            return nr < 20000;
        }

        @Override
        public Integer next() {
            return nr++;
        }
    };
}