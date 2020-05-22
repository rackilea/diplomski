Uri photoUri = data.getData();
                     String[] filePathColumn = {MediaStore.Images.Media.DATA};
                     Cursor cursor = getContentResolver().query(photoUri, filePathColumn, null, null, null); 
                        if (cursor.moveToFirst())
                        {
                            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                            String filePath = cursor.getString(columnIndex);
                            cursor.close();
                            Bitmap imageReturned = BitmapFactory.decodeFile(filePath);

                            showImageInLayout(imageReturned);