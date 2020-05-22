/**
         * Get a Cursor the history, e.g. records wich have a visits count > 0. Sorted by last visited date.
         * @param currentActivity The parent activity.
         * @return A Cursor to history records.
         * @see Cursor
         */
        public Cursor getHistory(Activity currentActivity) {
                String whereClause = Browser.BookmarkColumns.VISITS + " > 0";
                String orderClause = Browser.BookmarkColumns.DATE + " DESC";

                return currentActivity.managedQuery(android.provider.Browser.BOOKMARKS_URI, Browser.HISTORY_PROJECTION, whereClause, null, orderClause);
        }