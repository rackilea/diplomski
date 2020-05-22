Condition condition = new Condition() {
    @Override
    public boolean matches(Object o) {
        return o.getClass() == B.class;
    }};

Assertions.assertThat(list).areExactly(1, condition);