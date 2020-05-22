stickerhorizontalScroll.add(emojiiBitmapField2);
    emojiiBitmapField2.setChangeListener(new FieldChangeListener() {

        Row r;

        public void fieldChanged(Field field, int context) {
            openDatabse();
            int i = field.getIndex() + 1;
            try {
                // 1. create a SQLite DB
                // 3 insert a record
                // 4 query the record
                Statement st3 = db.createStatement("SELECT Name,ImageName FROM Smilies where id=" + i);
                try {
                    st3.prepare();
                } catch (Exception e) {
                    Dialog.alert("Exception" + e.getMessage());
                }
                Cursor c = st3.getCursor();
                while (c.next()) {
                    r = c.getRow();
                    stickerImageName = r.getString(1);
                }
                st3.close();
                closeDatabase();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    });
}