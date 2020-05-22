public boolean isIDExist(String _id){

            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.query(Company, new String[] { KEY_your_id}, KEY_your_id + "=?" ,

            new String[] { String.valueOf( _id)}, null, null, null, null);

            if (cursor != null){

                if(cursor.getCount() == 0){

                    cursor.close();
                    db.close();
                    return false;

                }else{

                    cursor.close();
                    db.close();
                    return true;
                }
            }
            return false;
        }