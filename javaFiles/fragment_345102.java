import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ChildTest extends MockBase {
    @InjectMocks private Child child;

    @Mock private ChildObjectDependency child_test_dependency_mock;


    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void check_that_mocks_are_correctly_injected() {
        assertNotNull(child.getBase_object_dependency());
        assertEquals(base_test_dependency_mock, child.getBase_object_dependency());

        assertNotNull(child.getChild_object_dependency());
        assertEquals(child_test_dependency_mock, child.getChild_object_dependency());
    }
}