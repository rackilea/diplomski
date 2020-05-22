@XmlRootElement(name = "jobs")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class JobList {

    private ArrayList<Job> jobList;

    @XmlElement(name="job")
    public ArrayList<job> getJobList(){
        return jobList;
    }

    public void setJobList(ArrayList<Job> jobList){
        this.jobList = jobList;
    }
}