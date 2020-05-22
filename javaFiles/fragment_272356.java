public class StudentTest {
    @InjectMock
    private Student student;

    // this mock will be injected into student
    // but the real method will be called (unless a method was stubbed explicitly).
    @Spy
    private Address address;

    @Test
    public void testStudentInfo(){
        String name = student.getStudentInfo("name");
    }
}