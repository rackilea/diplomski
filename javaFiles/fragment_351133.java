@Root
public class Example {
    @Element
    private int longitude;

    @Element
    private int latitude;

    @Element
    private int heartrate;

    @Attribute
    private int index;

    public Example() {
        super();
    }

    public Example(int longitude, int latitude, int heartrate, int index) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.heartrate = heartrate;
        this.index = index;
    }

    public int gelLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public int gelHeartrate() {
        return heartrate;
    }

    public int getId() {
        return index;
    }
}