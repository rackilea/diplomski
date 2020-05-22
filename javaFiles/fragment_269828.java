@Entity(name="status")
@Table(name="Status")
public class StatusDb {

    @Column(name="table_name")
    private String tableName;

    @Column(name="record_id")
    private String recordId;

    @Column(name="status_desc")
    private String description;

    // setters/getters
    // equals/hashCode
}

@Entity(name="actvity")
@Table(name="Activity")
public class ActivityDb {

    @Column(name="id")
    @Id
    private Long id;

    @Column(name="description")
    private String description;

    @OneToMany
    @Where(value="table_name='Activity'")
    @JoinTable(name="STATUS", joinColumn=@JoinColumn(name="id"), 
                        reverseJoinColumn=@JoinColumn(name="record_id")
    private Set<StatusDb> status;  // Had to to make 1:M to use where clause

    // setters/getters
    // equals/hashCode
}