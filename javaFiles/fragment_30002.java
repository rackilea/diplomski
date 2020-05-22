@Entity
public class Comment{
  private int idComment;
  private String text;
  @Embedded
  private User user;
}