public class VocCard implements Parcelable {

    ...
    ...

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(voc_foreign);
        dest.writeString(voc_native);
        dest.writeInt(learned ? 1 : 0);
        dest.writeInt(error_level);
    }

    /**
    * This constructor is invoked by the method 
    * createFromParcel(Parcel source) of the object CREATOR.
    * 
    * The order and number of writing and reading data to and from   
    * Parcel should be same 
    **/
    private VocCard(Parcel in) {
        voc_foreign = in.readString();
        voc_native = in.readString();
        learned = in.readInt() == 1;
        error_level = in.readInt();
    }

    /**
    * A constructor that initializes the VocCard object. 
    **/
    VocCard(String voc_foreign, String voc_native) {
        this.voc_foreign = voc_foreign;
        this.voc_native = voc_native;
    }

    ...
    ...

}