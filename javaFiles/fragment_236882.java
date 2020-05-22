public class Student {

    public static void main(String[] args) {
        StudentDto studentDto = new StudentDto(50);
        String degree = StudentUtil.getDegreeClassification(studentDto.getAverage());
        System.out.println(degree);
    }
}