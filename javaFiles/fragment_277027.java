findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(findViewById(R.id.list).getVisibility() == View.GONE||findViewById(R.id.list).getHeight() <= 0){
                <do something>
            }
            if(getSupportLoaderManager().getLoader(0) == null) {
                  getSupportLoaderManager().initLoader(0, null, EarthquakeActivity.this);
            } else {
                getSupportLoaderManager().restartLoader(0, null, EarthquakeActivity.this);
            }
        }
});