public class Space {
  @ManyToOne
  @JoinColumn(name="NORTH_BOUNDARY")
  private Boundary northBoundary;

  @ManyToOne
  @JoinColumn(name="EAST_BOUNDARY")
  private Boundary eastBoundary;

  @ManyToOne
  @JoinColumn(name="SOUTH_BOUNDARY")
  private Boundary southBoundary;

  @ManyToOne
  @JoinColumn(name="WEST_BOUNDARY")
  private Boundary westBoundary;
}