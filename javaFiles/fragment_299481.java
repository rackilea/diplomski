public class SpacePhoto implements Parcelable {

private String mUrl;
private String mTitle;

public SpacePhoto(String url, String title) {
    mUrl = url;
    mTitle = title;
}

protected SpacePhoto(Parcel in) {
    mUrl = in.readString();
    mTitle = in.readString();
}

public static final Creator<SpacePhoto> CREATOR = new Creator<SpacePhoto>() {
    @Override
    public SpacePhoto createFromParcel(Parcel in) {
        return new SpacePhoto(in);
    }

    @Override
    public SpacePhoto[] newArray(int size) {
        return new SpacePhoto[size];
    }
};

@Override
public int describeContents() {
    return 0;
}

@Override
public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(mUrl);
    parcel.writeString(mTitle);
}