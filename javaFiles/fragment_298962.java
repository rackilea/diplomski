public class StudentInfoService
{
    private Connection conn;

    public StudentInfoService(Connection conn)
    {
        this.conn = conn;
    }

    public StudentInfo getStudentInfo(long studentId) {
            //Uses the conn object to communicate with DB and creates
            // StudentInfo object with necessary information
            // and returns it to the caller.
    }
}