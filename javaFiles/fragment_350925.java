@Entity
public class Rate {

    @Id
    private String key;
    private Long remaining;
    private Long remainingQuota;
    private Long reset;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date expiration;

    // constructor, getters and setters 
}