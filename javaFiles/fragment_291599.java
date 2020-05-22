public class MyCursorAdapter extends CursorAdapter {


    public MyCursorAdapter(Context context, Cursor c) {
        super(context, c, true);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        return v;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.row,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        //Note Cursor will be positioned appropriately
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView quantity = (TextView) view.findViewById(R.id.quantity);
        CheckBox cb = (CheckBox) view.findViewById(R.id.checkboxmain2);

        name.setText(cursor.getString(cursor.getColumnIndex(SQLiteAdapter.KEY_NAME)));
        id.setText(cursor.getString(cursor.getColumnIndex(SQLiteAdapter._id)));
        quantity.setText(cursor.getString(cursor.getColumnIndex(SQLiteAdapter.KEY_QUANTITY)));
        cb.setChecked(cursor.getInt(cursor.getColumnIndex(SQLiteAdapter.KEY_CHECKED)) > 0);
        cb.setTag(cursor.getString(cursor.getColumnIndex(SQLiteAdapter._id))); //<<<<<<<<<< SET TAG to the ID
    }
}