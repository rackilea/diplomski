public class Word implements Parcelable {

    private int imageResource;
    private String title;

    public Word(int imageResource, String title) {
        this.imageResource = imageResource;
        this.title = title;
    }

    protected Word(Parcel in) {
        imageResource = in.readInt();
        title = in.readString();
    }

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        @Override
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imageResource);
        parcel.writeString(title);
    }
}