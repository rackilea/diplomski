@Entity
    @Table(name = "Period")
    public class Period implements Serializable {
      private List<Delay> delays = new ArrayList<Delay>();

      @OneToMany(mappedBy="period") //name of the field in joined entity
      public List<Delay> getDelays() {
        return delays;
      }
    }

   @Entity
   @Table(name = "Delay")
   public class Delay implements Serializable {

    private Period period;

    @ManyToOne
    @JoinColumn(name = "PERIODID")
    public Period getPeriod() {
       return period;
    }   
}