public class Posts {
    @Lob
    @Column(name="IMAGE", nullable=false)
    private byte[] image;

    //code

    public void setImage(byte[] image) { this.image = image; }
    public byte[] getImage() { return image; }
}