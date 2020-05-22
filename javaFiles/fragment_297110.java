for (int i = 0; i < chatUserConnect.size(); i++) {
                listMapItem.add(new MapItem(chatUserConnect.get(i).getLatitude(), chatUserConnect.get(i).getLongitude(),"" ,
                        chatUserConnect.get(i).getUserID(), chatUserConnect.get(i).getVehicleId()));
     }





import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public  class ChatUserConnect implements Parcelable
{
    @SerializedName("UserType")
    public String UserType;
    @SerializedName("UserID")
    public long UserID;
    @SerializedName("Latitude")
    public double Latitude;
    @SerializedName("Longitude")
    public double Longitude;
    @SerializedName("VehicleId")
    public long VehicleId;

    public ChatUserConnect( String UserType, long UserID, double Latitude, double Longitude, long VehicleId ) {
        this.UserType = UserType;
        this.UserID = UserID;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.VehicleId = VehicleId;
    }

    public long getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(long VehicleId) {
        this.VehicleId = VehicleId;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserID(String UserType) {
        this.UserType = UserType;
    }

    public long getUserID() {
        return UserID;
    }

    public void setUserID(long UserID) {
        this.UserID = UserID;
    }

    public double getLongitude() {
        return Longitude;
    }
    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }

    public double getLatitude() {
        return Latitude;
    }
    public void setLatitude(double Latitude) {
        this.Latitude = Latitude;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(UserType);
        dest.writeLong(UserID);
        dest.writeDouble(Latitude);
        dest.writeDouble(Longitude);
        dest.writeLong(VehicleId);
    }
    protected ChatUserConnect(Parcel in) {
        UserType = in.readString();
        UserID = in.readLong();
        Latitude = in.readDouble();
        Longitude = in.readDouble();
        VehicleId = in.readLong();
    }

    public static final Creator<ChatUserConnect> CREATOR  = new Creator<ChatUserConnect>() {
        @Override
        public ChatUserConnect createFromParcel(Parcel in) {
            return new ChatUserConnect(in);
        }

        @Override
        public ChatUserConnect[] newArray(int size) {
            return new ChatUserConnect[size];
        }
    };
}