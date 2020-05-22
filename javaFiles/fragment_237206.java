public Cursor getSuggestions(String query, int limit) {

    if (searchable == null) {
        return null;
    }

    String authority = searchable.getSuggestAuthority();
    if (authority == null) {
        return null;
    }

    Uri.Builder uriBuilder = new Uri.Builder()
            .scheme(ContentResolver.SCHEME_CONTENT)
            .authority(authority)
            .query("")  // TODO: Remove, workaround for a bug in Uri.writeToParcel()
            .fragment("");  // TODO: Remove, workaround for a bug in Uri.writeToParcel()

    // if content path provided, insert it now
    final String contentPath = searchable.getSuggestPath();
    if (contentPath != null) {
        uriBuilder.appendEncodedPath(contentPath);
    }

    // append standard suggestion query path
    uriBuilder.appendPath(SearchManager.SUGGEST_URI_PATH_QUERY);

    // get the query selection, may be null
    String selection = searchable.getSuggestSelection();
    // inject query, either as selection args or inline
    String[] selArgs = null;
    if (selection != null) {    // use selection if provided
        selArgs = new String[] { query };
    } else {                    // no selection, use REST pattern
        uriBuilder.appendPath(query);
    }

    if (limit > 0) {
        uriBuilder.appendQueryParameter("limit", String.valueOf(limit));
    }

    Uri uri = uriBuilder.build();

    // finally, make the query
    return mContext.getContentResolver().query(uri, null, selection, selArgs, null);
}