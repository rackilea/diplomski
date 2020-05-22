Yes you can pass you need to create your bean class like this:
import android.os.Parcel;
import android.os.Parcelable;
public class CustomClass implements Parcelable {

    private String name;
    private int thumbNail;

    public CustomClass() {
    }

    public CustomClass(String name, int thumbnail) {
        this.name = name;
        this.thumbNail = thumbnail;
    }

    protected CustomClass(Parcel in) {
        name = in.readString();
        thumbNail = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(thumbNail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CustomClass> CREATOR = new Creator<CustomClass>() {
        @Override
        public CustomClass createFromParcel(Parcel in) {
            return new CustomClass(in);
        }

        @Override
        public CustomClass[] newArray(int size) {
            return new CustomClass[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(int thumbNail) {
        this.thumbNail = thumbNail;
    }

}

=> how to call intent in send broadcast:

CustomClass bean = new CustomClass();
intent.putExtra("msg_bean", bean);
sendBroadcast(intent);

=> How to get object in onReceive() method:
public void onReceive(Context paramContext, Intent intent) {
CustomClass bean = intent.getExtras().getParcelable("msg_bean");
}