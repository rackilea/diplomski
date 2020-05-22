public class Home extends Activity implements LoaderManager.LoaderCallbacks<Cursor> {

// Constants
private static final String TAG = "Home";
private static final boolean DEBUG = true;
public static final int LOADER_CONTACTS_CURSOR = 1;

// Variables
private AdapterContacts adapter;



/**
 * Overrides
 */

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Set the view
    setContentView(R.layout.home);

    // Initialize CursorAdapter
    adapter = new AdapterContacts(this, null, 0);
    final LoaderManager.LoaderCallbacks<Cursor> iFace = this;
    adapter.setFilterQueryProvider(new FilterQueryProvider() {
        public Cursor runQuery(CharSequence constraint) {
            if (constraint != null) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("constraint", constraint);
                getLoaderManager().restartLoader(Home.LOADER_CONTACTS_CURSOR, bundle, iFace);
            } else {
                getLoaderManager().restartLoader(Home.LOADER_CONTACTS_CURSOR, null, iFace);
            }
            return getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        }
    });

    // Attach CursorAdapter to AutoCompleteTextView field
    AutoCompleteTextView field = (AutoCompleteTextView) findViewById(R.id.newPlayer_edit);
    field.setAdapter(adapter);

    // Initialize Cursor using LoaderManagers
    LoaderManager.enableDebugLogging(true);
    getLoaderManager().initLoader(LOADER_CONTACTS_CURSOR, null, this);
}

@Override
public void onDestroy() {
    if (DEBUG) Log.i(TAG, "Destroying activity");
    super.onDestroy();
}

@Override
public Loader<Cursor> onCreateLoader(int id, Bundle args) {
    if (DEBUG) Log.i(TAG, "Loader Callback: creating loader");
    Uri baseUri;

    if (args != null) {
        CharSequence constraint = args.getCharSequence("constraint");
        if (DEBUG) Log.i(TAG, "Constraint: " + constraint.toString());
        baseUri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(constraint.toString()));
    } else {
        if (DEBUG) Log.i(TAG, "No Constraint");
        baseUri = ContactsContract.Contacts.CONTENT_URI;
    }
    return new CursorLoader(this, baseUri, null, null, null, null);
}

@Override
public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
    if (DEBUG) Log.i(TAG, "Loader Callback: load finished");
    adapter.swapCursor(cursor);
}

@Override
public void onLoaderReset(Loader<Cursor> loader) {
    if (DEBUG) Log.i(TAG, "Loader Callback: resetting");
    adapter.swapCursor(null);
}
}