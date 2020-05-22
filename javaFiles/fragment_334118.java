@MappedSuperclass
public class Campaign {

    @ManyToOne
    private BusinessUser businessUser;
    /...
}