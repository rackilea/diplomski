@Override
public void writeToParcel(Parcel dest, int flags) {
    Parcelable[] a;
    /* 
        some stuff to populate "a" with Arrival 
        objects (which implements Parcelable) 
    */
    dest.writeParcelableArray(a, 0);
}