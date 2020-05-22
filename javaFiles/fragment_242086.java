public class FirstSubClass extends SuperClass {
    public static final Parcelable.Creator<FirstSubClass> CREATOR = new Creator<FirstSubClass>() {

        @Override
        public FirstSubClass[] newArray(int size) {
            return new FirstSubClass[size];
        }

        @Override
        public FirstSubClass createFromParcel(Parcel source) {
            return new FirstSubClass(source);
        }
    };

    public FirstSubClass() {
        super();
    }

    public FirstSubClass(Parcel source) {
        super(source);
    }

}