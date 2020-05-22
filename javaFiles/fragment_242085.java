public class SuperClass implements Parcelable {
    public static final Parcelable.Creator<SuperClass> CREATOR = new Creator<SuperClass>() {

        @Override
        public SuperClass[] newArray(int size) {
            return new SuperClass[size];
        }

        @Override
        public SuperClass createFromParcel(Parcel source) {
            return new SuperClass(source);
        }
    };

    private String label;

    public SuperClass() {
    }

    protected SuperClass(Parcel source) {
        label = source.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(label);
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }
}