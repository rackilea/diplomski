import android.os.Parcel;
import android.os.Parcelable;


public class MusicFile implements Parcelable {

    private Integer id;
    private String title;
    ...

    public MusicFile(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public MusicFile(){

    }

    protected MusicFile(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readInt();
        title = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(id);
        }
        dest.writeString(title);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MusicFile> CREATOR = new Parcelable.Creator<MusicFile>() {
        @Override
        public MusicFile createFromParcel(Parcel in) {
            return new MusicFile(in);
        }

        @Override
        public MusicFile[] newArray(int size) {
            return new MusicFile[size];
        }
    };
}