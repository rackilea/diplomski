@RunWith(EasyMockRunner.class) 
public class ExampleTest {

  @TestSubject 
  private ClassUnderTest classUnderTest = new ClassUnderTest(); // 2 

  @Mock 
  private Collaborator mock; // 1 

  @Test 
  public void testRemoveNonExistingDocument() { 
    replay(mock); 
    classUnderTest.removeDocument("Does not exist"); 
  } 
}