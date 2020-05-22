final Context context = this;
Runnable runnable = new Runnable() {
    @Override
    public void run() {
        ...
        setLatestInfo(context, charsequence1, charsequence2, pendingIntent);
    }
}