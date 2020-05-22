public class ListAdapter extends BaseAdapter implements View.OnClickListener {

    OnShareClickedListener mCallback;
    Context context;
    public static List<String> url_list;

    public ListAdapter(Context c, List<String> list) {
        this.context = c;
        url_list = list;
    }

    public void setOnShareClickedListener(OnShareClickedListener mCallback) {
        this.mCallback = mCallback;
    }

    public interface OnShareClickedListener {
        public void ShareClicked(String url);
    }


    @Override
    public void onClick(View v) {
        mCallback.ShareClicked("Share this text.");
    }
}