Cursor c = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    new String[] { /*columns you want */, null, null, null);
c.moveToFirst();
while(!c.isLast()) {
// add some data to your array list
}