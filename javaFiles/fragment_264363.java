@Entity 
@Table
public class Task {

    @Id
    @GeneratedValue
    private Integer id;

    // ...

    @OneToOne(mappedBy = "task_ref", orphanRemoval=true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Stuff stuff;

// ...
}

@Entity
@Table
public class Stuff {

    @Id
    @Column(name = "stuff_id")
    private Integer stuff_id;

    // ...

    @OneToOne(fetch = FetchType.LAZY)        
    @MapsId 
    @JoinColumn(name = "stuff_id") 
    private Task task_ref;

    // ...
}