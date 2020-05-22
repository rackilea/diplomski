@Override
public Loader<Cursor> onCreateLoader(int id, Bundle args) {

    return new SQLiteCursorLoader(getActivity()) {
        @Override
        public Cursor loadInBackground() {
            // Initialize your database
            TeamDatabase teamDatabase = new TeamDatabase(getActivity());

            Cursor cursor = teamDatabase.getAllTeams();

            if (cursor != null) {
                // Register the content observer here
                this.registerContentObserver(cursor, DBConstants.DB_TABLE_TEAM_URI);
            }

            return cursor;
        }
    };
}

@Override
public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
    // Set the cursor in your adapter. Handle null values in your setCursor function in your adapter. The cursor might return null when the table is empty.
    teamAdapter.setCursor(cursor);
    teamAdapter.notifyDataSetChanged();
}

@Override
public void onLoaderReset(Loader<Cursor> loader) {
}