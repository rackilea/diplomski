public int getSongIndex(String s,Context mContext) {
     String songName = s;
     String songTitle;
     final Cursor mCursor = mContext.getContentResolver().query(...);
     ...
  return songIndex;
}