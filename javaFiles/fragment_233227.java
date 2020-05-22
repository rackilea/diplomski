@RunWith(PowerMockRunner.class)
@PrepareForTest(StudentController.class)
public class StudentControllerTest {
    @Mock
    HttpServletRequest request;

    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void create() {
        //Arrange
        int expectedId = 1;
        when(studentService.create(any(Student.class)))
            .thenAnswer(i -> {
                Student student = (Student)i.getArguments()[0];
                //manipulate the student as needed.
                //Like setting an id

                //...student.setId(expectedId)

                return student;
            });

        //Act
        Student createdStudent = studentController.create(request, "Name", "New York", 1);

        //Assert
        assertTrue(createdStudent != null);
        assertTrue(expectedId == createdStudent.getStudentId());
    }
}