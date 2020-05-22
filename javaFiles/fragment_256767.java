private static class YourTask extends AsyncTask<Void, Void, Void> {

    private WeakReference<YourActivity> activityReference;

    YourTask(YourActivity context) {
        activityReference = new WeakReference<>(context);
    }

    @Override
    protected String doInBackground(Void... params) {

        return "task finished";
    }

    @Override
    protected void onPostExecute(String result) {

        YourActivity activity = activityReference.get();
        if (activity == null || activity.isFinishing()) return;

        activity.myVariable = "example";

        TextView textView = activity.findViewById(R.id.textview);
        textView.setText(result);
    }
}