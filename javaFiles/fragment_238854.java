@Entity
@Table(name="views")
public class View {

    @OneToMany
    @JoinColumn(name="view_id")
    @MapKey("position")
    private Map<Integer,ViewItem> viewItems = new HashMap<Integer,ViewItem>();
    ...
}

@Entity    
@table(name="view_items")
@DiscriminatorColumn(name="type")
public abstract class ViewItem {

   @Column(insertable = false, updatable = false)
   public String type;

   ...  
}