if (song.getType()==2)
{ 

  holder.song_play.setVisibility(View.Gone);
  holder.song_photo.setImageResource(R.drawable.folder);

}
else
{
 holder.song_play.setVisibility(View.VISISBLE);
 holder.song_photo.setImageResource(R.drawable.song);
}