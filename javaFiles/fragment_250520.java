@Override
public final void writeToParcel(Parcel p, int flags) {
    p.writeInt(typeNumber());
    write2(p);
}

public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

    @Override
    public Base createFromParcel(Parcel p) {
        switch (p.readInt()) {
            case CONCRETE1: return Concrete1.create2(p);
            case CONCRETE2: return Concrete2.create2(p);
            // etc
            default: throw new AssertionError();
        }
    }

    @Override
    public Base[] newArray(int size) {
         return new Base[size];
    }
}