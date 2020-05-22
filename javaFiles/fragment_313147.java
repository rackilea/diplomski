@RunWith(PowerMockRunner.class)
@PrepareForTest({ Test.class })
public class SampleTest {

@Mock
Person person;

@Test
public void testPrintName() throws Exception {
    PowerMockito.whenNew(Person.class).withNoArguments().thenReturn(person);
    Test test= new Test();
    test.testMethod();
    }
}