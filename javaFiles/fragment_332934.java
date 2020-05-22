package test;

import static org.junit.Assert.*;

import org.apache.catalina.connector.Response;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ControllerTest {

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    Controller controller;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCoursesWhenStudentIDNotFound() {
        Mockito.when(iStudentDAO.getStudentIdByToken("1234")).thenReturn(null);
        Response response = controller.courses("1234");
        assertEquals(403, response.getStatus())
    }

}