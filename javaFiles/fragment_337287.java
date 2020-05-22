private static DbHelperAndroid mInstance = null;

public static DbHelperAndroid getDb(Context ctx) {
    if (mInstance == null) {
        synchronized (TAG) { // any final static object will do
            // checking again inside the sync block, since it's a critical section.
            // I'm not doing this in the above if because it's really rare
            // and I don't want the overhead of locks all the time
            if (mInstance == null) {
                mInstance = new DbHelperAndroid(
                        ctx.getApplicationContext(), true);
            }
        }

    }
    return mInstance;
}