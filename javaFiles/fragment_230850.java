public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
{                   
   String artist = ((TextView) v).getText().toString();
   Intent i = new Intent().setClass(ArtistActivity.this, AlbumActivity.class);
   i.putExtra("artist", artist);
   startActivity(i);
}