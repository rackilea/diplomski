public  boolean checktitle ( String title){
            SQLiteDatabase db= this.getWritableDatabase();
            Cursor cur = db.rawQuery("SELECT * FROM stories where story_title='"+title+"'" ,null);
            if(cur.getCount()>0)
                return true;
            return false;
        }