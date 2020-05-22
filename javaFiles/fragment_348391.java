public class Response {
    @SerializedName("code") public int mCode;
    @SerializedName("data") public ResponseData mData;
}

public class ResponseData {
    @SerializedName("transport") public String mTransport;
    @SerializedName("nearstations") public List<Station> mStations;
}