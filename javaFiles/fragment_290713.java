@Entity
@Table(name = "your_view_name")
public class YourView {

   @Column(name="someColumnFromYourView")
   private String someColumnFromYourView;

   @Transient
   private List<Point> points;
   ...
}