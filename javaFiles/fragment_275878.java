public abstract class ApiResponse<T> {

    @SerializedName("data")
    private T mData;

    public T getData() {
        return mData;
    }

    //common code - success, etc.
}