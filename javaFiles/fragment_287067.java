@XmlRootElement
class Article {
    private String title;
    private String category;
    private List<ArticleImage> imageList;

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    @XmlElement
    public void setCategory(String category) {
        this.category = category;
    }

    public List<ArticleImage> getImage() {
        return imageList;
    }

    // for Extra Question... :D
    // method name changed!
    public void setImage(List<ArticleImage> imageList) {
        this.imageList = imageList;
    }
}

class ArticleImage {
    private String url;
    private String ext;

    public String getUrl() {
        return url;
    }

    @XmlAttribute
    public void setUrl(String url) {
        this.url = url;
    }

    public String getExt() {
        return ext;
    }

    @XmlAttribute
    public void setExt(String ext) {
        this.ext = ext;
    }
}