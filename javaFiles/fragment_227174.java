@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentInstitutionMapper studentInstitutionMapper;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void testStudentService_getPresentStudentCount1() {


        StudentParams studentParam = mock(StudentParams.class);

        Integer institutionTestId = 3539;
        when(studentParam.getInstitutionTestId()).thenReturn(institutionTestId);


        int i = studentService.getPresentStudentCount(studentParam);
        assertEquals(0, i);

    }
}