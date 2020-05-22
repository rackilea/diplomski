enum Animal implements BiFunction<String, Object, String> {
    CAT,
    DOG,
    BEAR {
        @Override
        public String apply(String s, Object o) {
            return "This is a Bear!!!";
        }
    };

    @Override
    public String apply(String s, Object o) {
        return "(" + name() + ":" + s + o.toString() + ")";
    }
}

public void test() {
    for (Animal animal : Animal.values()) {
        System.out.println(animal.apply("hello", "Hello"));
    }
}