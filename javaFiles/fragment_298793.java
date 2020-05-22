@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

private StudentService studentService;
private StudentRepository studentRepository;

@Test
public void findAll(){
    studentRepository = mock(StudentRepository.class);
    studentService = new StudentServiceImpl(studentRepository);
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student(1, "person1", "person1@mail.com"));
    studentList.add(new Student(2, "person2", "person2@mail.com"));

    when(studentRepository.findAll()).thenReturn(studentList);

    List<Student> expectedList = studentService.findAl();

    assertEquals(2, expectedList.size());
 }
}