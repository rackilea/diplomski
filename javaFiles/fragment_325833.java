public class Photo extends Media {
    private String someOtherAttribute;

    public Photo(Date date, String name) {
        createdOn = date;
        this.name = name;
    }
}