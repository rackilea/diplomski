public class Feeds {
    String img, title, subtitle;
    long id;

    public Feeds(long id, String img, String title, String subtitle) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.subtitle = subtitle;
    }
    public long getId(){
        return id;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

}