@Entity
public class Song {
  @Id
  @GeneratedValue
  private Long id;
  @OneToOne
  private SongFile songFile;      
}