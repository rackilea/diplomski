public static RequestQueue getRequestQueue(Context mContext) {
    if (mRequestQueue == null) {
        mRequestQueue = Volley.newRequestQueue(mContext);  
    } 
    return mRequestQueue;
}