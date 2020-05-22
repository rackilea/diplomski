public class AdapterContacts extends CursorAdapter {

// Constants
private static final String TAG = "AdapterContacts";
private static final boolean DEBUG = true;

// Variables
private TextView mName;

/**
 * Constructor
 */
public AdapterContacts(Context context, Cursor c, int flags) {
    super(context, c, flags);
}

/**
 * Overrides
 */

@Override
public View newView(Context context, Cursor cursor, ViewGroup parent) {
    // Inflate the views that create each row of the dropdown list
    final LayoutInflater inflater = LayoutInflater.from(context);
    final LinearLayout ret = new LinearLayout(context);
    ret.setOrientation(LinearLayout.VERTICAL);

    mName = (TextView) inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false);
    ret.addView(mName, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

    /*
    int nameIdx = cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY);
    mName.setText(cursor.getString(nameIdx));
    */

    return ret;
}

@Override
public void bindView(View view, Context context, Cursor cursor) {
    // Fill the dropdown row with data from the cursor
    int nameIdx = cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY);
    String name = cursor.getString(nameIdx);
    ((TextView) ((LinearLayout) view).getChildAt(0)).setText(name);
}

@Override
public String convertToString(Cursor cursor) {
    // Convert the dropdown list entry that the user clicked on
    // into a string that will fill the AutoCompleteTextView
    int nameCol = cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY);
    return cursor.getString(nameCol);
}

@Override
public void changeCursor(Cursor newCursor) {
    newCursor.close();
}
}