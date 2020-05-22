@Test
public void example1() {
    try {
        find("something");
        fail();
    } catch (NotFoundException e) {
        assertThat(e.getMessage(), containsString("could not find something"));
    }
    // ... could have more assertions here
}