// Create the array containing column names
String[] columns = new String[] { "ColumnNameX" };

// Create the array containing resource ids
int[] resources = new int[] { android.R.id.text1 };

// Create the cursor adapter
mCursorAdapter = new SimpleCursorAdapter(
    MyActivity.this,
    android.R.layout.simple_spinner_item,
    data,
    columns,
    resources);