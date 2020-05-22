@Embeddable
public class JobId implements Serializable {
    private int accId;
    private String env;

    @Enumerated(EnumType.STRING)
    private JobType jobType;
}