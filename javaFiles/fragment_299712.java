@Before
public void setUp() {
    mockA = Mockito.mock(A.class);
    mockB = Mockito.mock(B.class);
    testedClass = new TestedClass(mockA, mockB);
}