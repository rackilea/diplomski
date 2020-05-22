public static class ClassRoom {
    private String period; // A or B
    private String courseName; // MATH, SCIENCE or ENGLISH
    private Set<Integer> studentIds;

    public ClassRoom(String period, String courseName, Integer... studentIds) {
        this.period = period;
        this.courseName = courseName;
        this.studentIds = new HashSet<>(Arrays.asList(studentIds));
    }

    public String getPeriod() {
        return period;
    }

    public String getCourseName() {
        return courseName;
    }

    public Set<Integer> getStudentIds() {
        return studentIds;
    }

    @Override
    public String toString() {
        return "Period='" + period + '\'' +
                ", CourseName='" + courseName + '\'' +
                ", studentIds=" + studentIds;
    }
}