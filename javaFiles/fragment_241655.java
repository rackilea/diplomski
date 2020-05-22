public class ListAdapter extends CursorAdapter {
    static Cursor cursor;
public ListAdapter(Context context, Cursor cursor, int flags) {
    super(context, cursor, 0);
    setCursor(cursor);
    getCursor();
}
public void setCursor(Cursor cursor)
{
    this.cursor = cursor;
}
public Cursor getCursor(){
    return cursor;
}