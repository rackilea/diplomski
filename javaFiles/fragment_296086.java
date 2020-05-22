public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

    // Bail early if the cursor is null or there is less than 1 row in the cursor
    if (cursor == null || cursor.getCount() < 1) {
        return;
    }

    // Proceed with moving to the first row of the cursor and reading data from it
    // (This should be the only row in the cursor)
    if (cursor.moveToFirst()) {
        // Find the columns of item attributes that we're interested in
        int imageColumnIndex = cursor.getColumnIndex(ItemEntry.IMAGE_VIEW);
        int nameColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_NAME);
        int priceColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_PRICE);
        int quantityColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_QUANTITY);

        // Extract out the value from the Cursor for the given column index
        byte[] image = cursor.getBlob(imageColumnIndex);
        // populate the photos variable with bytes and the picture will save to the list view after editing item
        photos = Utils.getImage(image);
        String name = cursor.getString(nameColumnIndex);
        String price = cursor.getString(priceColumnIndex);
        int quantity = cursor.getInt(quantityColumnIndex);

        // Update the views on the screen with the values from the database
        // if I delete the if/else statement, error saying Attempt to get length of null array from method Utils.getImage
        // can remove once I get image to stick
        if (image != null) {
            mImageView.setImageBitmap(Utils.getImage(image));
        } else {
            mImageView.setImageBitmap(null);
        }
        mNameEditText.setText(name);
        mPriceEditText.setText(price);
        mQuantityTextView.setText(Integer.toString(quantity));
    }
}