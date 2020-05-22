@Entity("myCollection")
public class First {

    @Id
    private ObjectId id;
    private String title;
    @Embedded
    private List<Second> secondClass;