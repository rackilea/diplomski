public class ImagePK implements Serializable {
    protected Integer userID;
    protected String name;

    public ImagePK() {}

    public ImagePK(Integer userID, String name) {
        this.userID = userID;
        this.name = name;
    }
    // equals, hashCode
}