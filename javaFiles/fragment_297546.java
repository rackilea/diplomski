@Override
    public void writeToParcel(Parcel out, int flags) {
       // Write long value of Date
       out.writeLong(date_object.getTime());

    }

    private void readFromParcel(Parcel in) {
       // Read Long value and convert to date
        date_object = new Date(in.readLong());

    }