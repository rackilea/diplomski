public class FriendDetail implements Parcelable {

    private String full_name;
    private int privacy;

    public HeatFriendDetail(Parcel in) {
        this.full_name = in.readString();
        this.privacy = in.readInt();
    }

    public HeatFriendDetail() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.full_name);
        dest.writeInt(this.privacy);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public HeatFriendDetail createFromParcel(Parcel in) {
            return new HeatFriendDetail(in);
        }

        public HeatFriendDetail[] newArray(int size) {
            return new HeatFriendDetail[size];
        }
    };

    // GETTER SETTER//
}