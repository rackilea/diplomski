@Before
public void setUp() {
    PowerMockito.mockStatic(A.class);
    PowerMockito.when(A.getVal()).thenReturn("X");

    b = PowerMockito.mock(B.class);
    PowerMockito.when(b.getVal()).thenReturn("Y");
}