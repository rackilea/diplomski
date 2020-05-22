public class Course extends Student {
    private String courseid;
    private String coursedesc;
    private List<Subject> subjects;

    public Course()
    {
        this.courseid = "";
        this.coursedesc = "";
        subjects = new ArrayList<Subject>();
    }

    public Course(String courseid, String coursedesc)
    {
        this();
        this.courseid = courseid;
        this.coursedesc = coursedesc;
    }

    public void setCourseId(String courseid)
    {
        this.courseid = courseid;
    }

    public void setCourseDesc(String coursedesc)
    {
        this.coursedesc = coursedesc;
    }

    public String getCourseId()
    {
        return courseid;   
    }

    public String getCourseDesc()
    {
        return coursedesc;   
    }

    public void addSubject(Subject subject)
    {
        subjects.add(subject);
    }

    public List<Subject> getSubjects()
    {
        return subjects;
    }
}