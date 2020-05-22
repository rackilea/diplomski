@Override
public void writeToParcel(Parcel dest, int flags) {
   if (exception != null){
       dest.writeParcelable(exception, flags);
   }
}