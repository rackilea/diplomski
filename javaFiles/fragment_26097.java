private Order(Parcel in) {
    email = in.readString();
    if(in.readByte() == 1)
        timestamp = in.readLong(); //here to skip just like the writeToParcel
    in.readTypedList(items = new ArrayList<OrderItem>(), OrderItem.CREATOR);
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(email);
    if (timestamp == null) {
        dest.writeByte((byte) 0);
    } else {
        dest.writeByte((byte) 1);
        dest.writeLong(timestamp);
    }
    dest.writeTypedList(items);
}