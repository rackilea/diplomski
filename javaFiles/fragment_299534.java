public static class VoteId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String voter; // matches name of @Id attribute and type of User PK
    private ReviewId review; // matches name of @Id attribute and type of Review PK

    // ...

}