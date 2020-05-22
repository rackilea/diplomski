private final static List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);

@Test
public void closestOf21() {
    assertThat(closest(21, list), is(20));
}

@Test
public void closestOf19() {
    assertThat(closest(19, list), is(20));
}

@Test
public void closestOf20() {
    assertThat(closest(20, list), is(20));
}