@XmlRootElement(name = "Response")
public class Response {

    @XmlElement(name ="Status")
    private Status status;

    @XmlElements({
            @XmlElement(name = "Job", type = Job.class),
            @XmlElement(name = "Jobs", type = Jobs.class),
    })
    private List<?> jobs;
}