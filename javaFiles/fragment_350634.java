@Embeddable
public class XLinksMediaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "link_id", insertable = false, updatable = false)
    private int linkId;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;

    public XLinksMediaPK(){
    }

    public XLinksMediaPK(int linkId, String image) {
        this.linkId = linkId;
        this.image = image;
    }
    //getter and setter
}