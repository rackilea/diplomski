@Entity
@Table(name="worktime_times")
public class WorkTimeTimes {
    @Id
    @Column(name="worktime_times_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int worktimeTimesId;

    @Column(name="worktime_id")
    private int worktimeId;

    @Temporal(TemporalType.TIME)
    @Column(name="start_time")
    private Date startTime;

    @Temporal(TemporalType.TIME)
    @Column(name="end_time")
    private Date endTime;

    ...

}