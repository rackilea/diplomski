@RunWith(MockitoJUnitRunner.class)
public class Test1 {
    @InjectMocks
    MyBean bean;
    @Mock
    MyBean2 bean2;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldWork() {
        when(bean2.test2()).thenReturn("mocked return");
        assertThat(bean.test("ABC")).isEqualTo("ABCmocked return");
    }
}