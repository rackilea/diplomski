public class DataList {

    /**
     * NOTE changed id to use long rather than int
     */

    private long id;
    private byte[] image ;
    private String name;

    public DataList(int id, String name, byte[] image){

        this.id=id;
        this.name=name;
        this.image=image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}