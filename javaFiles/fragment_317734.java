public static <T> List<T> setMaxSize(
    final List<T> input, final int maxSize){

    return new ForwardingList<T>(){

        @Override
        public boolean addAll(Collection<? extends T> collection){
            return standardAddAll(collection);
        }

        @Override
        public boolean addAll(int index, Collection<? extends T> elements){
            return standardAddAll(index, elements);
        }

        public boolean add(T e) {
            checkMaxSize();
            return delegate().add(e);
        }

        @Override
        public void add(final int index, final T e){
            checkMaxSize();
            delegate().add(index, e);
        }

        private void checkMaxSize(){
            if(size() >= maxSize){
                throw new UnsupportedOperationException("Maximum Size "
                    + maxSize + " reached");
            }
        }

        @Override
        protected List<T> delegate(){
            return input;
        }
    };
}