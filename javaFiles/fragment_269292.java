@MappedSuperclass
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column(columnDefinition = "boolean default true", nullable = false)
    private boolean enabled = true;
// ...
}

@Entity
public class Course extends AbstractEntity {
    private String name;
    @ManyToOne(optional = false)
    private Professor professor;
    //...
}

@Entity
public class Question extends AbstractEntity {
    private String title;
    @ManyToOne(optional = false)
    private Course course;
    @ManyToOne(optional = false)
    private Professor professor;
    // ...
}