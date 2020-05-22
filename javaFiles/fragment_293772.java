@POST
@Path("/saveStudentDetail")
@Consumes(MediaType.APPLICATION_JSON)
public void saveStudentDetail(StudentDetailsTO student){
      String fname= student.getFirstName();
      String lname= student.getLastName();
      String address= student.getAddress();
    }