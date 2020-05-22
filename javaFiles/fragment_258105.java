package stackoverflow;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestClass {

    @Nested
    public class testingPersonClass {

        @InjectMocks
        public Person personOne = new Person("zakzak", 37);

        @Mock
        public Hobbie hobbie = new Hobbie("Sport");


/*
        @BeforeEach
        public void init() {
            MockitoAnnotations.initMocks(this);
        }
*/

        @Test
        public void testOne() {
            System.out.println("personOne " + personOne.toString());
        }
    }
}