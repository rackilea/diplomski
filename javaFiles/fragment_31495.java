@Override
public void onActivityCreated (Bundle savedInstanceState) {
    DatabaseHelper dbHelper = new DatabaseHelper(getContext());
    ProgressBar progressView = findViewById(R.id.FFProgress);
    new RefreshData(dbHelper, progressView).execute();
}

 private static class RefreshData extends AsyncTask<Void, Void, Void> {

        private final View progress;
        private final DatabaseHelper dbHelper;
        private String title;
        private Drawable drawable;

        public RefreshData(DatabaseHelper dbHelper, View progress) {
            this.dbHelper = dbHelper;
            this.progress = progress;
        }