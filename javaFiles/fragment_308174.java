public class Person extends BaseModel {

    @DesiredField
    private Date dateOfBirth;
    @DesiredField
    private String aadhaarNumber;

    private Set<EducationQualification> educationQualifications;

    // Rest of the fields and methods

}