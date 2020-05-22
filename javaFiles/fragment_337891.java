@Test
public void read() throws Exception {
    sut.open(new ExecutionContext());
    assertNotNull(sut.read());
    sut.close();
}