@Entity
@Table(name = "booklists")
@Data
@ToString(exclude = "user")
public class Booklist {     
    @Id
    private int id;
    @ManyToOne
    private Book book;      
    @ManyToOne
    private User user;      
    @ManyToOne
    private Year year;
}