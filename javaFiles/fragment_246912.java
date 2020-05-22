public class Task implements Parcelable {
private String myTask;
private String myDetails;

public static final Parcelable.Creator<Task> CREATOR
        = new Parcelable.Creator<Task>() {
    public Task createFromParcel(Parcel in) {
        return new Task(in);
    }

    public Task[] newArray(int size) {
        return new Task[size];
    }
};

public Task() {}

public Task(Parcel in){
    myTask = in.readString();
    myDetails = in.readString();
}

@Override
public int describeContents() {
    return 0;
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(myTask);
    dest.writeString(myDetails);
}