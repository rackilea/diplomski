mapper.addMapping(new GenericMapping<>(1, A.class,
        new Function<A, Integer>() {
            @Override
            public Integer apply(final A a1) {
                return a1.getIntegerA();
            }
        },
        new BiConsumer<A, Integer>() {
            @Override
            public void accept(final A a1, final Integer integerA) {
                a1.setIntegerA(integerA);
            }
        }));