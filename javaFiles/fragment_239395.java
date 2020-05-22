public class MyAdapter extends BaseAdapter {
    private Activity mActivity;

    public MyAdapter(Activity activity) {
        super(activity);
        mActivity = activity;
    }

    @Override
    public void notifyDataSetChanged() {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                super.notifyDataSetChanged();
            }
        }
    }
}