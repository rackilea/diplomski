public class ResourcesWrapper {
    @SerializedName("resources")
    private Map<String, Resources> mMapResources;

    public ArrayList<Resources> getList() {
        return new ArrayList<Resources>(mMapResources.values());
    }

    public static class Resources {
        @SerializedName("res-id")
        private String mResId;
        @SerializedName("duration")
        private String mDuration;
    }
}