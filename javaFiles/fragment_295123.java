public class PlaylistCursorAdapter extends CursorAdapter{

public boolean isAllItemsVisible;

public PlaylistCursorAdapter(Context context, Cursor cursor){
    super(context, cursor, 0);
    }

public static class ViewHolder{
CheckBox checkBox;
TextView playlistTitle;

public ViewHolder(View view){

    checkBox = (CheckBox)view.findViewById(R.id.checkBox);
    playlistTitle = (TextView)view.findViewById(R.id.playlistTitle);
}
}

@Override
public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
View view = LayoutInflater.from(context).inflate(R.layout.playlist_item, viewGroup, false);
ViewHolder viewHolder = new ViewHolder(view);
view.setTag(viewHolder);
return view;
}

@Override
public void bindView(View view, Context context, Cursor cursor) {

ViewHolder viewHolder = (ViewHolder)view.getTag();
if(isAllItemsVisible)
    viewHolder.checkBox.setVisibility(View.VISIBLE);
else
    viewHolder.checkBox.setVisibility(View.GONE);
int playlistName = cursor.getColumnIndex(MediaStore.Audio.Playlists.NAME);
String playlist = cursor.getString(playlistName);

viewHolder.playlistTitle.setText(playlist);
}
}