MainActivity activity;
List<mList> mData;
Dialog myDialog;

private MediaPlayer mediaPlayer;
private int playbackPosition=0;

private LinearLayout menu_dialog;
public RecyclerViewAdapter(MainActivity activity, List<mList> mData) {
    this.activity = activity;
    this.mData = mData;
}