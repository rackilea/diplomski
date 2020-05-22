private ClassUnderTest classUnderTest;

@Before
public void setUp() {
    ClassUnderTest cut = new ClassUnderTest();
    // inject dependencies into `cut`
    classUnderTest = Mockito.spy(cut);
}