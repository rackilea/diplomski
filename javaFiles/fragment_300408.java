public class Attendance {

    @JsonProperty("classID")
    private int classId;

    @JsonProperty("id of students who missed class")
    private int[] missingStudentIds;

}