@Override
public void writeToParcel(Parcel out, int flags) {
   // Write object
   out.writeSerializable(date_object);

}

private void readFromParcel(Parcel in) {
   // Read object
    date_object = (java.util.Date) in.readSerializable();

}