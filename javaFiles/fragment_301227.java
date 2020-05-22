private boolean mSkipClip;

@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    final ClipboardManager mClipboard = (ClipboardManager)mAct.getSystemService
            (Context.CLIPBOARD_SERVICE);

    mClipboard.addPrimaryClipChangedListener(new ClipboardManager
            .OnPrimaryClipChangedListener() {
        @Override
        public void onPrimaryClipChanged() {
            if (mSkipClip) {
                mSkipClip = false;
            } else {
                // Append custom string
                ClipData clipData = new ClipData(mClipboard.getPrimaryClip());
                clipData.addItem(new ClipData.Item("Copied from xx app"));
                mSkipClip = true;
                mClipboard.setPrimaryClip(clipData);
            }
        }
    });
}