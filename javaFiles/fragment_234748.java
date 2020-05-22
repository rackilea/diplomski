public class Parking implements Parcelable {
...
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(mId);
        parcel.writeString(mCode);
        ...
    }

    public static final Parcelable.Creator<Parking> CREATOR
        = new Parcelable.Creator<Parking>() {
        public Parking createFromParcel(Parcel in) {
            return new Parking(in);
        }

        public Parking[] newArray(int size) {
            return new Parking[size];
        }
    };
}