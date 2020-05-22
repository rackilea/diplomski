public class SyncWrapper<T, I> {

    @SearializedName("LastSyncDateTime")
    private DateTime lastSyncDateTime;
    @SearializedName("Data")
    private Collection<T> data;
    @SearializedName("DeleteIds")
    private Collection<I> deleteIds;