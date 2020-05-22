class LoadAnnouncementDataFromAPI extends AsyncTask<String,String,String> {
    OnAddListener listener;

    public void setOnAddListener(OnAddListener listener) {
        this.listener = listener;
    }

    LoadAnnouncementDataFromAPI(OnAddListener listener) {
        this.listener = listener;
        // Or may be pass it to the constructor...
    }

    protected String doInBackground(String... params) {
        // Your logic
        // And then!
        if(listener!=null){
            listener.onAdd(new AnnouncementBlock(announcementJSON));
        }
        // ...
    }
}