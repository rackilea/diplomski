@Embeddable
public class CommentID implements Serializable
{
  private String e_mail;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="TIME_POSTED")
  private Date timeOfComment;
}