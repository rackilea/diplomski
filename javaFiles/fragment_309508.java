@Override
public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                    String sortOrder) {
    // Get readable database
    SQLiteDatabase database = mDbHelper.getReadableDatabase();

    // This cursor will hold the result of the query
    Cursor cursor;

    // Figure out if the URI matcher can match the URI to a specific code
    int match = sUriMatcher.match(uri);
    switch (match) {
        case PETS:
            // For the PETS code, query the pets table directly with the given
            // projection, selection, selection arguments, and sort order. The cursor
            // could contain multiple rows of the pets table.
            cursor = database.query(PetEntry.TABLE_NAME, projection, selection, selectionArgs,
                    null, null, sortOrder);
            break;
        case PET_ID:
            // For the PET_ID code, extract out the ID from the URI.
            // For an example URI such as "content://com.example.android.pets/pets/3",
            // the selection will be "_id=?" and the selection argument will be a
            // String array containing the actual ID of 3 in this case.
            //
            // For every "?" in the selection, we need to have an element in the selection
            // arguments that will fill in the "?". Since we have 1 question mark in the
            // selection, we have 1 String in the selection arguments' String array.
            selection = PetEntry._ID + "=?";
            selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };

            // This will perform a query on the pets table where the _id equals 3 to return a
            // Cursor containing that row of the table.
            cursor = database.query(PetEntry.TABLE_NAME, projection, selection, selectionArgs,
                    null, null, sortOrder);
            break;
        default:
            throw new IllegalArgumentException("Cannot query unknown URI " + uri);
    }
    return cursor;
}