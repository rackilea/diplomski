mActivity.runOnUiThread(new Runnable() {
    @Override
    public void run() {
        MyAdapter.super.notifyDataSetChanged();
    }
}