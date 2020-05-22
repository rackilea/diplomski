public class MyCustomCursorAdapter extends CursorAdapter {
    Lights calling_activity; //<<<<<<<<<<@@@@@@@@@@@ ADDED for interface

    public MyCustomCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
        this.calling_activity = (Lights) context; //<<<<<<<<<<@@@@@@@@@@@ ADDED for interface
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        if (position % 2 == 0) {
            view.setBackgroundColor(0xFFAAAAFF);
        } else {
            view.setBackgroundColor(0xAAAAAAFF);
        }
        return view;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.adapter,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ((TextView)view.findViewById(R.id.id)).setText(cursor.getString(cursor.getColumnIndex(DatabaseManager._ID)));
        ((TextView)view.findViewById(R.id.KEYCODE)).setText(cursor.getString(cursor.getColumnIndex(DatabaseManager.TITLE)));
        ((TextView)view.findViewById(R.id.NAME)).setText(cursor.getString(cursor.getColumnIndex(DatabaseManager.DESC)));

        Switch thisswitch = view.findViewById(R.id.the_switch);
        thisswitch.setTag(cursor.getString(cursor.getColumnIndex(DatabaseManager._ID)));
        thisswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                /**
                Toast.makeText(buttonView.getContext(),
                        "You clicked the switch for ID " + (String) buttonView.getTag() +
                                " the status is now " + (new Boolean(isChecked)).toString(),
                        Toast.LENGTH_SHORT)
                        .show()
                **/
                calling_activity.myOnCheckedChangedHandler((String)buttonView.getTag(),isChecked); //<<<<<<<<<<@@@@@@@@@@@ ADDED for interface
            }
        });
    }
}