@Embedabble
public class Checker {
    @Column(name="checker_id", ...)
    private String makerId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time_approved", ...)
    private Date timeApproved;
}