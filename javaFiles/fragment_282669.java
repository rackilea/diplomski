@Entity
public class Workshop
{  
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;

     @ManyToOne(fetch=FetchType.LAZY)
     @JoinColumn(name="key")
    private School school;