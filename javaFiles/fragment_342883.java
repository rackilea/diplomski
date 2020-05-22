class SongsFragment {

  interface RecyclerViewClickListener {
    void onClick(int position); // you can pass any parameters here you need from recyclerview to activity
  }

  private RecyclerViewClickListener mListener;

  // set the listener here from activity
  public void setListener(RecyclerViewClickListener listener) {
    mListener = listener;
  }

  @Override
  public void onItemClick(int position) {
    // TODO: Implement this method
    String TAG = "AAA";
    Log.e(TAG, "lol" + position);
    mListener.onClick(position);
  }
}