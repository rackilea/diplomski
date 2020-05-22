public class PhotoResult {
    @SerializedName("photos")
    @Expose
    public Photos photos;
}

public class Photos {
    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("pages")
    @Expose
    public Integer pages;
    @SerializedName("perpage")
    @Expose
    public Integer perpage;
    @SerializedName("total")
    @Expose
    public String total;
    @SerializedName("photo")
    @Expose
    public List<Photo> photo = new ArrayList<Photo>();
}

public class Photo {
    ...
}