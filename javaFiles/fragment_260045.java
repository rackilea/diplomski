public class CollegeStudent extends Student{

    String studentId;

    @Override
    public String getIdentity(){
        return this.studentId;
    }
}