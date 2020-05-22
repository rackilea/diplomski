@Entity
@Table(name="filters")
public class Filter {
   ...
   @ManyToMany(cascade=CascadeType.ALL)
   @FilterJoinTable(name="time", condition=":insertTime >= insertTime")
   private Set<Ad> ads; 
   ...