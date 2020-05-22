public class Links implements Parcelable {

    private String name;
    private Streams streams;

    public Links(String name, Streams streams) {
        this.name = name;
        this.streams = streams;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param streams the streams to set
     */
    public void setStreams(Streams streams) {
        this.streams = streams;
    }

    /**
     * @return the streams
     */
    public Streams getStreams() {
        return streams;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelable(streams, flags);
    }

    public static Parcelable.Creator<Links> CREATOR = new Parcelable.Creator<Links>() {

        @Override
        public Links createFromParcel(Parcel source) {
            String name = source.readString();
            Streams streams = source.readParcelable(Streams.class.getClassLoader());
            return new Links(name, streams);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    };
}