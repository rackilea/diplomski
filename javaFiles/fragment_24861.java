public class Programme {
  ..
  @ManyToMany
  @JoinTable(name="prog_ep_perf",
                   joinColumns=@JoinColumn(name="episodeId"),
                   inverseJoinColumns=@JoinColumn(name="programmeId"))
  @MapKeyJoinColumn(name="performerId")
  Map<Performer, Episode> prog_ep_perf;
  ..
}