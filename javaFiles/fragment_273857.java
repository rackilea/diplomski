@Entity
public class Item {

    @NotNull
    @ManyToOne
    private User user;  // plus getter + setter

}