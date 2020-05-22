public static class Playlist extends ArrayList<Track> implements Parcelable {

    String module;
    String name, playlistId;

    public Playlist(String name) {
        super();
        this.name = name;
    }

    protected Playlist(Parcel in) {
        module = in.readString();
        name = in.readString();
        playlistId = in.readString();
        //this line you might need to tweak & error handle, I've jsut written this from memory
        super.addAll( (Collection<? extends Track>) Arrays.asList( in.readParcelableArray(Track.class.getClassLoader() )) );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(module);
        dest.writeString(name);
        dest.writeString(playlistId);
        dest.writeParcelableArray(toArray(new Track[size()]), flags);
    }

    public static final Creator<Playlist> CREATOR = new Creator<Playlist>() {
        @Override
        public Playlist createFromParcel(Parcel in) {
            return new Playlist(in);
        }

        @Override
        public Playlist[] newArray(int size) {
            return new Playlist[size];
        }
    };

}