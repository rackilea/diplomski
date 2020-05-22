public class AnInteger implements Parcelable {
    private int c_value;

    public AnInteger(int value) {
        this.c_value = value;
    }

    public int getC_value() {
        return c_value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.c_value);
    }

    protected AnInteger(Parcel in) {
        this.c_value = in.readInt();
    }

    public static final Parcelable.Creator<AnInteger> CREATOR = new Parcelable.Creator<AnInteger>() {
        @Override
        public AnInteger createFromParcel(Parcel source) {
            return new AnInteger(source);
        }

        @Override
        public AnInteger[] newArray(int size) {
            return new AnInteger[size];
        }
    };
}