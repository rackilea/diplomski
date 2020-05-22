public class SomeIntegers implements Parcelable {
    private ArrayList<AnInteger> c_values;

    public SomeIntegers() {
        c_values = new ArrayList<>();
        c_values.add(new AnInteger(1));
        c_values.add(new AnInteger(2));
        c_values.add(new AnInteger(3));
        c_values.add(new AnInteger(4));
        c_values.add(new AnInteger(29));
        c_values.add(new AnInteger(30));
    }

    public String report() {
        String g = "";
        for (AnInteger ai : c_values) {
            if (!g.isEmpty()) {
                g = g + ", ";
            }
            g = g + ai.getC_value();
        }
        return (g.isEmpty() ? "Empty" : g);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.c_values);
    }

    protected SomeIntegers(Parcel in) {
        this.c_values = in.createTypedArrayList(AnInteger.CREATOR);
    }

    public static final Parcelable.Creator<SomeIntegers> CREATOR = new Parcelable.Creator<SomeIntegers>() {
        @Override
        public SomeIntegers createFromParcel(Parcel source) {
            return new SomeIntegers(source);
        }

        @Override
        public SomeIntegers[] newArray(int size) {
            return new SomeIntegers[size];
        }
    };
}