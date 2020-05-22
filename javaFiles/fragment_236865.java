List<Integer> ints = createData(new Supplier<Integer>() {
        Random rand = new Random();

        @Override
        public Integer get() {
            return rand.nextInt(100);
        }
    }, 10);