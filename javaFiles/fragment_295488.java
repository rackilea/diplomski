public class ObjectName implements Parcelable {


    public ObjectName(Parcel in) {
        super();
        readFromParcel(in);
    }

    public static final Parcelable.Creator<ObjectName> CREATOR = new Parcelable.Creator<ObjectName>() {
        public ObjectName createFromParcel(Parcel in) {
            return new ObjectName(in);
        }

        public ObjectName[] newArray(int size) {

            return new ObjectName[size];
        }

    };

    public void readFromParcel(Parcel in) {
        Value1 = in.readInt();
        Value2 = in.readInt();
        Value3 = in.readInt();

    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Value1);
        dest.writeInt(Value2);
        dest.writeInt(Value3);
    }
}