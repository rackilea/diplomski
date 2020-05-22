public class EmployeeHistory {

    private String role;
    private String duration;
    private String employer;

    public EmployeeHistory() {
    }

    public EmployeeHistory(String role, String duration, String employer) {
        this.role = role;
        this.duration = duration;
        this.employer = employer;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

}