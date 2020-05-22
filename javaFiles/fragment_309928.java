int count = 0;
if (cursor.moveToFirst()) {
  do {
    // Read your row here

    ++count;
  } while (cursor.moveToNext() && count<20);
}
cursor.close();