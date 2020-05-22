@Embedabble
public class Maker {
    @Column(name="maker_id", ...)
    private String makerId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time_added", ...)
    private Date timeAdded;
}