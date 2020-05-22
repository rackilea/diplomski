@Entity
@FilterDef(name="groupMeetingFilter",
        parameters={@ParamDef( name="fromDate", type="date"), @ParamDef(name="toDate", type="date")} )
public class Group {
    @Id //
    @GeneratedValue() //
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true) @JoinTable(name = "group_meetings")
    @Filter(
        name = "groupMeetingFilter",
        condition="start <= :fromDate and end >= :toDate"
    )
    private final List<GroupMeeting> meetings = new ArrayList<>();
}