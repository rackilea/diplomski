@Spy
Beta beta;

@Spy
Alpha alpha;

public void beforeTest() {
    when(alpha.getBeta()).thenReturn(beta);
    when(beta.getCharlie()).thenReturn(charlie);
}