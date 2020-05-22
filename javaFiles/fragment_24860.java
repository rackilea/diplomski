public class Programme {
  ..
  @OneToMany(mappedby="programme")
  private Set<Episode> episodes;
  ..

public class Episode {
  ..
  @ManyToOne
  @JoinColumn(name = "programmeId")
  private Programme programme;
  ..