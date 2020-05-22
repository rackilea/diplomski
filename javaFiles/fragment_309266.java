public class News {

    private String message, author, thumb_author, type;
    private Long timestamp;

    public Map<String,String> images; // this is a new field for the images

    public String getMessage() {
       return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    ...