public class NetworkActivity{
    private Context mContext;
    Cache cache;
    NetworkActivity(Context mContext){
        this.mContext=mContext;
        this.cache = new DiskBasedCache(mContext.getCacheDir(), 1024 * 1024);
    }
}