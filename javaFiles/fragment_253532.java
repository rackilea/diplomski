import android.os.Parcel;
import android.os.Parcelable;

public class `Transaction` implements Parcelable {
    private float value;
    private int transaction_Date;
    private String description;

    public Transaction(float value, int transaction_Date, String description) {
        super();
        this.value = value;
        this.transaction_Date = transaction_Date;
        this.description = description;
    }

    public float getValue() {
        return value;
    }

    public int getTransaction_Date() {
        return transaction_Date;
    }

    public String getDescription() {
        return description;
    }


    public void setValue(float value) {
        this.value = value;
    }

    public void setTransaction_Date(int transaction_Date) {
        this.transaction_Date = transaction_Date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(this.value);
        dest.writeInt(this.transaction_Date);
        dest.writeString(this.description);
    }

    protected Transaction(Parcel in) {
        this.value = in.readFloat();
        this.transaction_Date = in.readInt();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Transaction> CREATOR = new Parcelable.Creator<Transaction>() {
        @Override
        public Transaction createFromParcel(Parcel source) {
            return new Transaction(source);
        }

        @Override
        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };
}