public class ABC {    
    @Expose
    @SerializedName("image")
    String imageUrl

    XYZ image;
}
...
Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();