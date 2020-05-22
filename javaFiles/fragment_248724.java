/**
     * Class Constructor will only be used for non-static Referencing in a static condition.
     */
    public UpdateHandler(Context context, DownloadManager dm){
        this.mContext = context;
        this.manager = dm;  
    }