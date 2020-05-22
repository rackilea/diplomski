public class Actors implements Parcelable {

    private String name;
    private String description;
    private String dob;
    private String country;
    private String height;
    private String spouse;
    private String children;
    private String image;

    public Actors() {
        // TODO Auto-generated constructor stub
    }

    public Actors(String name, String description, String dob, String country,
                  String height, String spouse, String children, String image) {
        super();
        this.name = name;
        this.description = description;
        this.dob = dob;
        this.country = country;
        this.height = height;
        this.spouse = spouse;
        this.children = children;
        this.image = image;
    }


    protected Actors(Parcel in) {
        name = in.readString();
        description = in.readString();
        dob = in.readString();
        country = in.readString();
        height = in.readString();
        spouse = in.readString();
        children = in.readString();
        image = in.readString();
    }

    public static final Creator<Actors> CREATOR = new Creator<Actors>() {
        @Override
        public Actors createFromParcel(Parcel in) {
            return new Actors(in);
        }

        @Override
        public Actors[] newArray(int size) {
            return new Actors[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(dob);
        parcel.writeString(country);
        parcel.writeString(height);
        parcel.writeString(spouse);
        parcel.writeString(children);
        parcel.writeString(image);
    }
}