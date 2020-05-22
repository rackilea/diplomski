ArrayList<Integer> mMoodsArray = new ArrayList<>();
while (mCursor.moveToNext()){
   String mComment = mCursor.getString(2);
   int mMood = mCursor.getInt(3);
   mCommentsArray.add(mComment);
   mMoodsArray.add(mMood);
}