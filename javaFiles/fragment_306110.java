static final Function<String, Integer> parseInt = Integer::parseInt;

@Test
public void test() {
    Function<String, Integer> foo = parseInt;
    Function<String, Integer> bar = parseInt;
    assertThat(foo, equalTo(bar));
}