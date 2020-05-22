public class Video extends Media {
    private String someAttribute;

    public Video(Date date, String name) {
        createdOn = date;
        this.name = name;
    }
}