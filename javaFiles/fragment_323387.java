@Entity
@Table(name = "Duty_Manager")
public class DutyManager {
@Id
@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
@SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "MNG_SEQ")
@Column(name = "MANAGER_ID")
private Long id;
@Column(name = "manager_title", nullable = false)
private String title;
@Column(name = "manager_name", nullable = false)
private String name;
@Column(name = "manager_age", nullable = false)
private int age;

public DutyManager() {
}


//getters and setters
}



@Entity
@Table(name = "DM_Schedule")
public class DM_Schedule {
@Id
@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
@SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "SCH_SEQ")
@Column(name = "Schedule_ID")
private Long id;
@ManyToOne
@JoinColumn(name = "manager_id", nullable = false)
private DutyManager manager;
@Column(name = "date_from", nullable = false)
private Date from;
@Column(name = "date_to", nullable = false)
private Date to;

public DM_Schedule() {
}


//getters and setters
}