public class ReviewId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String reviewer; // matches name of @Id attribute and type of User PK
    private Long reviewedAlbumId;

    // ...

}