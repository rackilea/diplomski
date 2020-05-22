public class TestedClassTest{
  @Spy
  private List<String> strings;

  @Spy
  @InjectMocks
  TestedClass testedClass = new TestedClass();

}