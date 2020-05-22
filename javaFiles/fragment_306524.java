public class MyCursorAdapter extends CursorAdapter {

    SQLiteAdapter sqliteAdapter;
    MyCursorAdapter thisCursorAdapter;


    public MyCursorAdapter(Context context, Cursor c) {

        super(context, c, true);
        sqliteAdapter = new SQLiteAdapter(context);
        thisCursorAdapter = this;
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
    public void bindView(View view, Context context, final Cursor cursor) {

        //Note Cursor will be positioned appropriately
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView quantity = (TextView) view.findViewById(R.id.quantity);
        CheckBox cb = (CheckBox) view.findViewById(R.id.checkboxmain2);
        Button eod = (Button) view.findViewById(R.id.editordelete);

        name.setText(cursor.getString(cursor.getColumnIndex(SQLiteAdapter.KEY_NAME)));
        id.setText(cursor.getString(cursor.getColumnIndex(SQLiteAdapter._id)));
        quantity.setText(cursor.getString(cursor.getColumnIndex(SQLiteAdapter.KEY_QUANTITY)));
        cb.setChecked(cursor.getInt(cursor.getColumnIndex(SQLiteAdapter.KEY_CHECKED)) > 0);
        cb.setTag(cursor.getString(cursor.getColumnIndex(SQLiteAdapter._id))); //<<<<<<<<<< SET TAG to the ID
        eod.setTag(cursor.getString(cursor.getColumnIndex(SQLiteAdapter._id)));
        // dynamically add the listeners as opposed to coding onCLick in layout XML
        eod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get the id from the id TextView, within the view hierarchy rather than from the buttons tag
                // NOTE assumes the Button's parent is a LinearLayout (for simplicity)

                // This in theory is the recommended way rather than setting the tag
                LinearLayout ll = (LinearLayout) v.getParent();
                TextView id = ll.findViewById(R.id.id), name = ll.findViewById(R.id.name);
                final long item_id_fromview = Long.valueOf(id.getText().toString());
                final String item_name = name.getText().toString();

                // get the id from the tag
                long item_id_fromtag = Long.valueOf(v.getTag().toString());
                // get the if from the cursor that is the source of the Listview, it should be positioned accordingly
                long item_id_fromcursor = cursor.getLong(cursor.getColumnIndex(SQLiteAdapter._id));

                // Show both
                Toast.makeText(v.getContext(),
                        "The id (from the view hierarchy) is " + String.valueOf(item_id_fromview) +
                                " or (from the tag) is " + String.valueOf(item_id_fromtag) +
                                " or (from the cursor) is" + String.valueOf(item_id_fromcursor)
                        , Toast.LENGTH_SHORT).show();
                AlertDialog.Builder mydialog = new AlertDialog.Builder(v.getContext());
                mydialog.setMessage("EDIT or DELETE Row:- ID: " + String.valueOf(item_id_fromview) + "Name: " + item_name);
                mydialog.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sqliteAdapter.delete(item_id_fromview);
                        refreshList();
                    }
                });
                mydialog.setNeutralButton("EDIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sqliteAdapter.updateById(item_id_fromview,SQLiteAdapter.KEY_NAME,item_name + " Updated");
                        refreshList();
                    }
                });
                mydialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                mydialog.show();
            }
        });
    }
    private void refreshList() {
        thisCursorAdapter.swapCursor(sqliteAdapter.queueAll());
        thisCursorAdapter.notifyDataSetChanged();
    }
}