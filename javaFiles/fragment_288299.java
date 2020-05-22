Uri uri = Uri.parse("content://media/external/images/media/65");

                String projection [] = { 
                          MediaStore.Images.Media.DATA
                        , MediaStore.Images.Media.DISPLAY_NAME
                        , MediaStore.Images.Media.SIZE
                        , MediaStore.Images.Media.MIME_TYPE
                        , MediaStore.Images.Media.DATE_MODIFIED
                        , DocumentsContract.Document.COLUMN_LAST_MODIFIED
                        };
                Cursor cursor = getContentResolver().query(uri, projection, null, null, null);

                if ( cursor==null)
                {   

                return; 
                }

                cursor.moveToFirst();

                String data        = cursor.getString(0);
                String displayName = cursor.getString(1);
                String size        = cursor.getString(2);
                String mimeType    = cursor.getString(3);
                String dateModified    = cursor.getString(4); // null
                String dateModified2    = cursor.getString(5);

                Toast.makeText(context,
                             "DISPLAY_NAME: " + displayName
                            + "\nDATA: " + data
                            + "\nSIZE: " + size
                                + "\nmimeType: " + mimeType
                                + "\n" +MediaStore.Images.Media.DATE_MODIFIED + ": " + dateModified
                                + "\n" +DocumentsContract.Document.COLUMN_LAST_MODIFIED + ": " + dateModified2
                            , Toast.LENGTH_LONG).show();
                cursor.close();