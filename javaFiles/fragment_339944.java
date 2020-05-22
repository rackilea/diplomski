public static class AsyncBackgroundColor extends AsyncTask<String, String, Integer> {
    WeakReference<View> view;
    WeakReference<Adapter> adapter;

    AsyncBackgroundColor(Adapter ad, View view) {
        this.view = new WeakReference<>(view);
        this.adapter = new WeakReference<>(ad);
    }

    @Override
    protected Integer doInBackground(String... strings) {
        return 1;
    }

    @Override
    protected void onPostExecute(Integer color) {
        view.get().setBackgroundColor(color);
        adapter.get().notifyDataSetChanged();
    }
}