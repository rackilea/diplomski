public class Encounter extends JPASupport implements java.io.Serializable {    
      @ManyToOne
      @JoinColumn(name="referralid", referencedColumnName="id",//otherstuff)
      private Referral referral; 
}


 public class Referral extends JPASupport implements java.io.Serializable { 

    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="referral")
    private Set<Encounter> encounters;

}