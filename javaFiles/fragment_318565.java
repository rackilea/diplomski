public class ListCustomObjects implements Parcelable{


String name;
String path;

public ListCustomObjects() {

}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getPath() {
    return path;
}

public void setPath(String path) {
    this.path = path;
}

public ListCustomObjects(Parcel in) {
    name = in.readString();
    path= in.readString();

}


@Override
public int describeContents() {
    return 0;
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    dest.writeString(path);
}

public static final Parcelable.Creator<ListCustomObjects> CREATOR = new Parcelable.Creator<ListCustomObjects>() {
    public ListCustomObjects createFromParcel(Parcel in) {
        return new ListCustomObjects(in);
    }

    public ListCustomObjects[] newArray(int size) {
        return new ListCustomObjects[size];

    }
};

}