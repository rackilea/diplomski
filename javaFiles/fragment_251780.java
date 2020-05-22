String projection [] = {

                          MediaStore.Images.Media.DATA
                        , MediaStore.Images.Media.DISPLAY_NAME
                        , MediaStore.Images.Media.SIZE};
                Cursor cursor = getContentResolver().query(data.getData(), projection, null, null, null);

                if ( cursor==null)
                {
                    Toast.makeText(context, "cursor==null\n\ncould not query content resolver for\n\n" + path, Toast.LENGTH_LONG).show();

                    return;
                }

                cursor.moveToFirst();
                String data = cursor.getString(0);
                String displayName = cursor.getString(1);
                String size = cursor.getString(2);

                Toast.makeText(context, "getContentResolver().openInputStream() ok\n\n" + path
                            + "\n\nDISPLAY_NAME: " + displayName
                            + "\nDATA: " + data
                            + "\nSIZE: " + size
                            , Toast.LENGTH_LONG).show();
                cursor.close();