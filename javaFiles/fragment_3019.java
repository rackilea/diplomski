@Entity
@Table(name = "tbl_user_settings", uniqueConstraints = {@UniqueConstraint(columnNames={"user_id"})})
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Settings
{
@Id
@SequenceGenerator(name="someSequence", sequenceName="SEQ_SOMENAME", allocationSize =1)
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="someSequence")
@Column(name="id")
private int setting_id;

@OneToOne
private User user;

@ManyToOne
private SomeObject someobject;

@ManyToMany
@JoinTable(
name="tbl_settings_objecteproxy_v2",
joinColumns = @JoinColumn(name = "id"),
inverseJoinColumns = @JoinColumn( name = "objectproxy_id"))
private Set<SomeObject> objectProxy;

/*...the rest...*/
}