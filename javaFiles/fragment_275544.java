public class SongAdapter extends CursorAdapter implements SectionIndexer{

...other code... 

@Override
public void bindView(View view, Context context, Cursor cursor) {
    TextView title1 = (TextView) view.findViewById(R.id.titlelist);
    TextView artist1 = (TextView) view.findViewById(R.id.artistlist);
    ImageView album1 = (ImageView) view.findViewById(R.id.iconlist);

    String title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
    String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
    String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
   long albumId = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));
      StringBuilder titleBuild = new StringBuilder();
      titleBuild.append(title);
      if(titleBuild.length() > 35)
      {
      titleBuild.setLength(32);
      title = titleBuild.toString()+"...";
      }
      else
      {
          title = titleBuild.toString();
      }
      StringBuilder artistBuild = new StringBuilder();
      artistBuild.append(artist);
      if(artistBuild.length() > 35)
      {
      artistBuild.setLength(32);
      artist = artistBuild.toString()+"...";
      }
      else
      {
      artist = artistBuild.toString();
      }



<---->
// new code
new ImageLoader(album1).execute();

// old code album1.setImageDrawable(ImageLoader.drawable);
title1.setText(title);
artist1.setText(artist);
}

}