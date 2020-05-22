public class SecondSubClass extends SuperClass {
    public static final Parcelable.Creator<SecondSubClass> CREATOR = new Creator<SecondSubClass>() {

        @Override
        public SecondSubClass[] newArray(int size) {
            return new SecondSubClass[size];
        }

        @Override
        public SecondSubClass createFromParcel(Parcel source) {
            return new SecondSubClass(source);
        }
    };

    public SecondSubClass() {
        super();
    }

    public SecondSubClass(Parcel source) {
        super(source);
    }

}