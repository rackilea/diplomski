public class Streams implements Parcelable {
    private String link;
    private String stream;

    public Streams(String link, String stream) {
        this.link = link;
        this.stream = stream;
    }
    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }
    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }
    /**
     * @param stream the stream to set
     */
    public void setStream(String stream) {
        this.stream = stream;
    }
    /**
     * @return the stream
     */
    public String getStream() {
        return stream;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(link);
        dest.writeString(stream);
    }

    public static final Parcelable.Creator<Streams> CREATOR = new Parcelable.Creator<Streams>() {

        @Override
        public Streams createFromParcel(Parcel source) {
            String link = source.readString();
            String stream = source.readString();
            return new Streams(link, stream);
        }

        @Override
        public Streams[] newArray(int size) {
            return new Streams[size];
        }
    };

}