@Entity
public class ArriveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    .. existing fields...    


    @ContentId
    private String contentId;

    @ContentLength
    private long contentLength = 0L;

    // if you have rest endpoints
    @MimeType
    private String mimeType = "text/plain";
}