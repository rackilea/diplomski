List<Integer> result = filter(new LinkedList<Integer>(), array, 
    new Predicate<Integer>() {
        public boolean invoke(Integer arg_p) {
            return (arg_p % 2 == 0);
        }
    });