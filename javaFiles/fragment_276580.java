public class UserInstance {
    public static UserHelper mInstance;
    private static final ReentrantLock lock = new ReentrantLock();

    public static UserHelper getInstance() {
        if (null == mInstance){
            lock.lock();
            try{
               if (null == mInstance){
                    mInstance = new UserHelper();
               }
            }
            finally{
                lock.unlock();
            }
        }
        DebugLog.e(mInstance.toString());
        return mInstance;
  }