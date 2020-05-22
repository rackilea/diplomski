public class AutoCompleteCursorAdapter extends CursorAdapter implements Filterable {

private TextView txtVerbName, txtVerbDefinition;
private Cursor mCursor;
private Context mContext;
private final LayoutInflater mInflater;

public AutoCompleteCursorAdapter(Context context, Cursor c) {
    super(context, c, true);
    mInflater = LayoutInflater.from(context);
    mContext = context;
}

@Override
public void bindView(View view, Context context, Cursor cursor) {
    TextView txtVerbName = (TextView) view.findViewById(R.id.txtVerbName);
    TextView txtVerbDefinition = (TextView) view.findViewById(R.id.txtVerbDefinition);

    txtVerbName.setText(cursor.getString(1));
    txtVerbDefinition.setText(cursor.getString(2));
}

@Override
public View newView(Context context, Cursor cursor, ViewGroup parent) {
    final View view = mInflater.inflate(R.layout.result_item, parent, false);
    return view;
}

@Override
public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
    // this is how you query for suggestions
    if (getFilterQueryProvider() != null) {
        return getFilterQueryProvider().runQuery(constraint);
    }
    if (constraint != null) {

        DBAdapter db = new DBAdapter(mContext);
        db.open();

        mCursor = db.getVerbsContaining(constraint);

        mCursor.moveToFirst();
        db.close();
    }
    return mCursor;
}