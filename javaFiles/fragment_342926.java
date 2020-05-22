@Entity
@Table(name ="algo")
public class Algo{
  ...
  @ManyToMany(fetch = FetchType.LAZY )
  @OrderBy("start")
  protected List<DbMatch> matches = new ArrayList<DbMatch>();