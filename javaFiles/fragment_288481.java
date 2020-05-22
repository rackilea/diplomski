public class AlbumWrapper implements Parcelable {

    // insert CREATOR here

    public final String artist;
    public final String mbid;

    public AlbumWrapper(Album a) {
        this.artist = a.getArtist();
        this.mbid = a.getMbid();
    }

    private AlbumWrapper(Parcel in) {
        this.artist = in.readString();
        this.mbid = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(artist);
        dest.writeString(mbid);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}