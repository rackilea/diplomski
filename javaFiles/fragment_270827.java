public class ImageOrderResult {
    //Used for general Error Tracing
    public String status = "";
    public String message = "";
    public String errorTrace = "";

    @SerializedName("image")
    public Image image = null;

    @SerializedName("isVisible")
    public boolean isVisible= false; 


    public class Image{
        @SerializedName("preferenceOrder")
        public ArrayList<String> flowers= new ArrayList<String>();
    }
}