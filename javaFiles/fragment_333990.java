@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(getmName());
    dest.writeFloat(getPriceStud());
    dest.writeFloat(getPriceEmp());
    dest.writeFloat(getPriceGuest());
}