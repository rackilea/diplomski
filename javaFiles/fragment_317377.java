public Bitmap getImage(){

    String qu = "select data from table where id = (select max(id) from table)" ;
    Cursor cur = db.rawQuery(qu, null);

    if (cur.moveToFirst()){
        byte[] imgByte = cur.getBlob(0);
        cur.close();
        return BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
    }
    if (cur != null && !cur.isClosed()) {
        cur.close();
    }       

    return null ;
}