class StudentEntity {
 int age ;
 String name;

 //getter
 //setter

 public StudentDTO _toConvertStudentDTO(){
    StudentDTO dto = new StudentDTO();
    //set dto values here from StudentEntity
    return dto;
 }

}