@RunWith(MockitoJUnitRunner.class)
public class ClassToTestTest {

    @Mock AnotherClass anotherClass;
    @InjectMocks ClassToTest classToTest;

    @Test public void ensure_that_value___Z___is_passed_to___AnotherClass() {
        classToTest.methodToTest(1, 2);

        verify(anotherClass).receiveSomething(eq(3));
    }
}