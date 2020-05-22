public abstract class Category implements Parcelable {
    private static Map<Integer, Category> categoryMap = new TreeMap<Integer, Category>();

    protected String title;
    protected Integer  id;

    static {
        categoryMap.put(0, new Taxi());
        categoryMap.put(1, new Hotel());
    }

    protected Category(){}

    protected Category(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInteger(id);
        dest.writeString(title);
    }

    abstract void generateCodes();
    abstract String getImageIcon();

};

public final class Taxi extends Category {
    public Taxi() {
        title = "taxi";
        id = 1547845;
    }

    protected Taxi(Parcel in) {
        super(in);
    }

    public static final Parcelable.Creator<Taxi> CREATOR = new Parcelable.Creator<Taxi>() {
        public Category createFromParcel(Parcel in) {
            return new Taxi (in);
        }

        public Category [] newArray(int size) {
            return new Taxi[size];
        }
    };
};

public final class Hotel extends Category {
    public Hotel() {
        title = "hotel";
        id = 1397866;
    }

    protected Hotel(Parcel in) {
        super(in);
    }

    public static final Parcelable.Creator<Hotel> CREATOR = new Parcelable.Creator<Hotel>() {
        public Category createFromParcel(Parcel in) {
            return new Hotel (in);
        }

        public Category [] newArray(int size) {
            return new Hotel[size];
        }
    };
};