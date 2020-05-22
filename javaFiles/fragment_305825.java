@Entity
public class Event {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String eventId;

    private String event_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String publishedDate;   

    @Column(nullable = false)
    private String endTime;         

    @ManyToOne
    @JoinColumn(name="user_id")   
    @Column(nullable = false)
    private User user;

    // Getters / Setters omitted

}