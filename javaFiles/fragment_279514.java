public class Book implements Serializable {

    @SerializedName("author")
    private String author;

    @SerializedName("title")
    private String title;

    @SerializedName("pages")
    private String pages;

    @SerializedName("imageURL")
    private String imageURL;

    @SerializedName("description")
    private String description;

    @SerializedName("categories")
    private String categories;

    @SerializedName("moreInfoLink")
    private String moreInfoLink;

    @SerializedName("language")
    private String language;

    @SerializedName("progress")
    private int progress = 0;

    @SerializedName("startTime")
    private long startTime = 0L;

    @SerializedName("endTime")
    private long endTime = 0L;

    public Book (String author, String title, String pages, String description, String imageURL, String categories, String moreInfoLink, String language) {
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.description = description;
        this.imageURL = imageURL;
        this.categories = categories;
        this.moreInfoLink = moreInfoLink;
        this.language = language;
    }
}