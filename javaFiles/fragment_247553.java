import android.os.Parcel;
import android.os.Parcelable;

public class IconItem implements Parcelable {

    private String name;
    private int resId;

    public IconItem(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }

    public String getName() {
        return this.name;
    }

    public int getResId() {
        return this.resId;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(resId);
    }

    public static final Creator<IconItem> CREATOR = new Creator<IconItem>() {
        @Override
        public IconItem createFromParcel(Parcel in) {
            String name = in.readString();
            int redId = in.readInt();
            return new IconItem(name, redId);
        }

        @Override
        public IconItem[] newArray(int size) {
            return new IconItem[size];
        }
    };
}