@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Uni")
public class Uni
{

    @XmlElement(name = "Semester")
    protected List<Semester>    semester;

    public List<Semester> getSemester()
    {
        if (this.semester == null)
        {
            this.semester = new ArrayList<Semester>();
        }
        return this.semester;
    }

}