// The contacts from the contacts content provider is stored in this cursor
    mMatrixCursor = new MatrixCursor(new String[]{"_id", "name", "photo", "details"});

// Adapter to set data in the listview
    mAdapter = new SimpleCursorAdapter(getBaseContext(),
            R.layout.lv_layout,
            mMatrixCursor,
            new String[]{"name", "photo", "details"},
            new int[]{R.id.tv_name, R.id.iv_photo, R.id.tv_details}, 0);