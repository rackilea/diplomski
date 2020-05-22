@Controller
class MyController {

    public String my(){

    //Call the conversion method here like
    StudentEntity entity = myDao.getStudent(1);
    StudentDTO dto = entity._toConvertStudentDTO();

    //As vice versa

    }

}