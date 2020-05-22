@Override
public void onCreate(Bundle bundle) {
    super.onCreate(bundle);

    String[] from = { ObjectViewContract.Columns.LABORCODE };
    int[] to = { android.R.id.text1 };

    mAdapter = new SimpleCursorAdapter(getSherlockActivity(), android.R.layout.select_dialog_item, null, from, to, 0);
    getLoaderManager().initLoader(0, null, this);
}

@Override
public Dialog onCreateDialog(Bundle bundle) {
    AlertDialog.Builder adb = new AlertDialog.Builder(getSherlockActivity());
    adb.setTitle(getString(R.string.menu_title_objectfilter));
    adb.setAdapter(mAdapter, this);
    return adb.create();
}