public class TestResourceB {
  ResourceB tested_b;
  @Mock ResourceC mocked_c;

  @Before
  public void init_tested_and_mocks() {
    MockitoAnnotations.initMocks(this);
    tested_b = new ResourceB(mocked_)
  }

  @Test
  public void ensure_result_from_ResourceC_is_returned() {
    // given 
    when(mocked_c.callFuncA()).thenReturn("result that should be returned");

    // when
    String output = tested_b.callFuncA();

    // then
    assertThat(output).isEqualTo("result that should be returned");
  }
}