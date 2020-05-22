@Entity()
 @Table(name = "alien"  schema = "\"hib\"")
 public class Alien {
    @Id
    private int aid;
    public int getAid() {
        return aid;
    }
    public void setAid(int aid) {
        this.aid = aid;
    }
  }