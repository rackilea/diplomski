class MyUnitTest {

    // system under test
    MyUnit sut;

    @Mock
    PersonDao personDaoMock;

    @BeforeEach
    public setup() {
        initMocks(this);
        sut = new MyUnit("some", "parameters");
    }

    @Test
    void myTest() {
        // setup test environment using a mock
        var somePerson = new Person("101", "John", "Doe");
        doReturn(somePerson).when(personDaoMock.findById("101"));

        // run test
        var actualValue = sut.doSomething();

        // check results
        assertThat(actualValue).isNotNull();
    }
}