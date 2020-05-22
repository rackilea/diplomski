public class TestClassUnderTest { 

     public class ClassUnderTest extends BaseClassForClassUnderTest 
     { 
        public ClassUnderTest(ISomeInterface si) 
        { 
           super(si); 
         } 
         //... 
      } 
@Test 
public void testSuperConstructorCall() 
{ 
    final ISomeInterface si = new ISomeInterface() 
    { 
    }; 

    Mockit.setUpMock(BaseClassForClassUnderTest.class, new Object() { 
        @Mock 
        public void $init(ISomeInterface si_param) 
        { 
            assertNotNull(si_param); 
            assertTrue(si_param == si); 
        } 
    }); 

    ClassUnderTest cut = new ClassUnderTest(si); 
}