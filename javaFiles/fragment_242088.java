public class SomeClass implements Parcelable {
    public static final Parcelable.Creator<SomeClass> CREATOR = new Creator<SomeClass>() {

        @Override
        public SomeClass[] newArray(int size) {
            return new SomeClass[size];
        }

        @Override
        public SomeClass createFromParcel(Parcel source) {
            return new SomeClass(source);
        }
    };

    private String name;
    private SuperClass[] array;

    public SomeClass(String name, SuperClass[] array) {
        this.name = name;
        this.array = array;
    }

    protected SomeClass(Parcel source) {
        this.name = source.readString();
        Parcelable[] temp = source.readParcelableArray(SuperClass.class.getClassLoader());
        array = new SuperClass[temp.length];
        for (int i = 0; i < temp.length; i++) {
            array[i] = (SuperClass) temp[i];
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        if (array == null || array.length == 0) {
            sb.append(" Array is empty");
        } else {
            sb.append(" Array:");
            for (SuperClass sc : array) {
                sb.append(sc.getClass().getSimpleName());
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public SuperClass[] getArray() {
        return array;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelableArray(array, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}