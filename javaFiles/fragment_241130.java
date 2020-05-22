@Entity
@Table
public class Student implements Serializable {
private static final long serialVersionUID = 1L;
@EmbeddedId
private SubjectMark subjectMarkId;
private String otherField;
// setters, getters
}

//Composite class
@Embeddable
public class SubjectMark implements Serializable {
private String cId;
// setter, getter
}


//Controller
@GetMapping(value = "getstdata")
public String getStData(@RequestParam(value="cid") String cid) {
Student student = new Student();

student.setSubjectMark(new SubjectMark());
student.getSubjectMark().setCId(cid);//cid value dynamic
// some other code
return "";
}