public class StudentModel {

    int studentId;
    String studentName; 

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int restaurantId) {
        this.studentId = resturantId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString(){
       return this.studentName;
    }

}