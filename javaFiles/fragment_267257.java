@MappedSuperclass
@Data
@EqualsAndHashCode(of = "id")
public class ListId {
    @Column(name="list_id")
    private int listId;     
    @Id
    private int id;
}
@Entity
@Table(name = "booklists")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Booklist extends ListId {  
    @ManyToOne
    private Book book;
}
@Entity
@Table(name = "userlists")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Userlist extends ListId {  
    @ManyToOne
    private User user;
    @ManyToOne
    private Year year;
}