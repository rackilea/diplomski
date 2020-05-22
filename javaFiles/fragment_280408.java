@Entity
@Table(name="ACTIVITY")
public class Activity {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
  private int key;
  private String text;

  @OneToMany(mappedBy="activity")
  private List<Tag> tags;

  private String title;
  private boolean valid;
  public Activity(int key, String text, List<Tag> tags, String title) {
    this.key = key;
    this.text = text;
    this.tags = tags;
    this.title = title;
    valid = true;
  }
}

@Entity
@Table(name="TAG")
public class Tag {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  @ManyToOne
  @JoinColumn(name="activity_id", nullable=false)
  private Activity activity;

  private String keyword;

  public Tag(String keyword){
    this.keyword = keyword;
    activityId = -1;
  }
}