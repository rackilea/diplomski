@Entity
public class Song {
  @Id
  @GeneratedValue
  private Long id;
  private Long songFileId;
}