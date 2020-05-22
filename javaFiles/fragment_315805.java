@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(title);
    dest.writeInt(size);        
    dest.writeStringList(words);
    dest.writeInt(data.size()); // write list size
    for (String[] letters : data) { 
        dest.writeStringArray(letters); //write each element
    }
}

public PuzzelSetter(Parcel parcel) {
    title = parcel.readString();
    size = parcel.readInt();        
    parcel.readStringList(words);
    int size = parcel.readInt(); // read size
    for (int i = 0; i < size; i++) {
        String[] letters = parcel.createStringArray(); // read each element
        data.add(letters);
    }
}