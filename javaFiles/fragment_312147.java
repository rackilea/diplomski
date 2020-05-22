@Table(name = "Categories")
public class Category extends Model { 

    @Setter
    @Getter
    @Column(name = "Name")
    private String name;
}