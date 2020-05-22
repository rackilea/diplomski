public class SongsManager {
private ArrayList<Song> songsList;
public void getMp3Songs(Context ctx) {
    Uri allSongsUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
    Cursor cursor =  ctx.getContentResolver().query(allSongsUri, null, null, null, selection);
    if (cursor != null) {
        if (cursor.moveToFirst()) {
            do {
                Song song = new Song(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media._ID)),
                                     cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)),
                                     cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)),
                                     cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)));
                songsList.add(song);
//                    album_name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
//                    int album_id = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
//                    int artist_id = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST_ID));
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}