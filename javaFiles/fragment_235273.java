@Test
public void takeUserInput() {
    InputStream in = new ByteArrayInputStream("1".getBytes());
    System.setIn(in);
    // instantiate and exercise your object under test
    // assert something meaningful
}