public class ListCursorAdapter extends CursorAdapter {

LayoutInflater inflater;

public ListCursorAdapter(Context context, Cursor cursor) {
    super(context, cursor, 0);
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}

@Override
public View newView(Context context, Cursor cursor, ViewGroup parent) {
    return inflater.inflate(R.layout.list_item, parent, false);
}

@Override
public void bindView(View view, Context context, Cursor cursor) {
    TextView todo = (TextView) view.findViewById(R.id.todoText);
    String todoTextDB = cursor.getString(1);
    todo.setText(todoTextDB);
}
}