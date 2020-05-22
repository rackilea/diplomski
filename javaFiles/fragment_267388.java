protected Movie(Parcel in) {
    vote_count = in.readInt();
    id = in.readInt();
    video = in.readByte() != 0;
    title = in.readString();
    popularity = in.readFloat();
    poster_path = in.readString();
    original_language = in.readString();
    original_title = in.readString();
    genre_ids = in.createStringArrayList();
    backdrop_path = in.readString();
    adult = in.readByte() != 0;
    overview = in.readString();
}

@Override
public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(vote_count);
    parcel.writeInt(id);
    parcel.writeByte((byte) (video ? 1:0));
    parcel.writeString(title);
    parcel.writeFloat(popularity);
    parcel.writeString(poster_path);
    parcel.writeString(original_language);
    parcel.writeString(original_title);
    parcel.writeStringList(genre_ids);
    parcel.writeString(backdrop_path);
    parcel.writeByte((byte) (adult ? 1:0));
    parcel.writeString(overview);
    parcel.writeLong(release_date.getTime());
}