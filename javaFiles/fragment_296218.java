protected A(Context context, String mId, OnLoadCompleteListener<Cursor> listener) {
    super(context);
    this.mCursorLoader = new CursorLoader(context);
    this.mCursorLoader.registerListener(0, listener);
    this.mId = mId;
}