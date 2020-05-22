class StudentDTO  {
 int age ;
 String name;

 //getter
 //setter

 public StudentEntity _toConvertStudentEntity(){
    StudentEntity entity = new StudentEntity();
    //set entity values here from StudentDTO
    return entity ;
 }

}