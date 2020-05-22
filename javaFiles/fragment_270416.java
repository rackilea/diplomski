public class DataObject implements Parcelable {

    public String someData;
    public String someMoreData;

    @Override
    public int describeContents() {
        return 0;
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(someData);
    dest.writeString(someMoreDate);
}

//Constructor for parceler
public DataObject(Parcel src) {
    someData = src.readString();
    someMoreData = src.readString();
}

public static final Parcelable.Creator<DataObject> CREATOR = 
                new Parcelable.Creator<DataObject>() {

    public DataObject createFromParcel(Parcel in) {
        return new DataObject(in);
    }

    public DataObject[] newArray(int size) {
        return new DataObject[size];
    }
};