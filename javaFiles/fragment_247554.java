import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class IconsCategory implements Parcelable {

    private String name;
    private ArrayList<IconItem> iconsArray = new ArrayList<>();

    public IconsCategory(String name, ArrayList<IconItem> iconsArray) {
        this.name = name;
        this.iconsArray = iconsArray;
    }


    public static final Creator<IconsCategory> CREATOR = new Creator<IconsCategory>() {
        @Override
        public IconsCategory createFromParcel(Parcel in) {
            String name = in.readString();
            ArrayList<IconItem> icons = new ArrayList<>();
            in.readTypedList(icons, IconItem.CREATOR);
            return new IconsCategory(name, icons);
        }

        @Override
        public IconsCategory[] newArray(int size) {
            return new IconsCategory[size];
        }
    };

    public String getCategoryName() {
        return this.name;
    }

    public ArrayList<IconItem> getIconsArray() {
        return iconsArray.size() > 0 ? this.iconsArray : null;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeTypedList(iconsArray);
    }
}