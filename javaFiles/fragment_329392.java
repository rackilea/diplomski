@Override
public void onClick(View v) {
    int position = getAdapterPosition();
    mCursor.moveToPosition(position);

    Intent i = new Intent(v.getContext(), ShoeDetailActivity.class);
    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

    int imgValue = mCursor.getColumnIndex(DatabaseContract.ShoeColumns.SHOE_IMAGE);
    int shoeBrandName = mCursor.getColumnIndex(DatabaseContract.ShoeColumns.SHOE_BRAND);
    int shoeName = mCursor.getColumnIndex(DatabaseContract.ShoeColumns.SHOE_NAME);

    i.putExtra("ImageBit", mCursor.getBlob(imgValue));
    i.putExtra("ShoeName", mCursor.getString(shoeBrandName));
    i.putExtra("BrandName", mCursor.getString(shoeName));

    v.getContext().startActivity(i);
}