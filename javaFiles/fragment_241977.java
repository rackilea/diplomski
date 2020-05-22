// Notice that the activity is implementing the OnAddListener interface.
class YourActivity extends Activity implements OnAddListener {

    // ... Some logic life cycle callbacks

    // I suppose you're doing something similar
    private void startUpdating(){
        mLoadAnnouncementDataFromAPI.setListener(this); // set the listener.
    }

    // Your callback.
    @Override
    public void onAdd(final AnnouncementBlock announcementBlock) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Now you're sure it's running in the UI thread ;)
                mAnnouncementAdapter.items.onAdd(announcementBlock);
            }
        });
    }
}