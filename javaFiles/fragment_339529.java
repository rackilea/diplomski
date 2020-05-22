@XmlRootElement(name = "Response")
public class Response {

    @XmlElement(name ="Status")
    private Status status;

    @XmlElement(name = "Job")
    private List<Job> jobs;

    @XmlElementWrapper(name = "Jobs")
    @XmlElement(name = "Job")
    private List<Job> jobsWrapped;

}