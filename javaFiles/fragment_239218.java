@Entity
@Table(name = "PREFERENCES")
public class UserPreferences implements Preferences {
    private Long id;
    private Panel defaultPanelToShow;
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="prefSeq")
    @SequenceGenerator(name="prefSeq", sequenceName = "SQ_PREFERENCES_ID", allocationSize = 10, initialValue = 1)
    @Column(name="PREFERENCES_ID")
    public Long getId() {
        return id;
    }

    @Column(name="DEFAULT_USER_PANEL")
    @Enumerated(EnumType.STRING)
    public Panel getDefaultRequestPanel() {
        return defaultPanelToShow;
    }

    @OneToOne
    @JoinTable(name="PREFS_JOIN_TABLE", joinColumns=@JoinColumn(name="PREFERENCES_ID", unique=true), inverseJoinColumns=@JoinColumn(name="PERSON_ID", unique=true))
    public Person getPerson() {
        return person;
    }
}