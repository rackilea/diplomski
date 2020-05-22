@Entity
class Domain {
  @ManyToOne //add column definitions as needed
  private Domain parent;      //each Domain with parent==null is a root domain, all others are subdomains

  @OneToMany //add column definitions as needed
  private List<Domain> subdomains;
}