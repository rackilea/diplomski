private void fillData() {

    mNotesCursor = helper.fetchAllData();

    String[] from = new String[] { MySQLiteHelper.NAME, MySQLiteHelper.PASSWORD,
        MySQLiteHelper.CB_GETREIDE, MySQLiteHelper.CB_FASTENTAG,
        MySQLiteHelper.CB_WOCHENPLAN, MySQLiteHelper.CB_DIET,
        MySQLiteHelper.SP_ART, MySQLiteHelper.PHOTO  };

    int[] to = new int[] { R.id.label, R.id.gewicht, 
        R.id.getreide,
        R.id.fastentag, 
        R.id.wochenplan, 
        R.id.diet, 
        R.id.spinner,
        R.id.imageButton1};


    adapter = new MyAdapter(getActivity(),
        R.layout.hundeliste_item, mNotesCursor, from, to, 0);

    mMyListView.setAdapter(adapter);

}


 private class MyAdapter extends SimpleCursorAdapter{

        private Context mContext;
        private int layout;
        private Cursor cursor;
        private final LayoutInflater inflater;

        public MyAdapter(Context context,int layout, Cursor cursor, String[] from, int[] to) {
            super(context,layout,cursor,from,to);
            this.layout=layout;
            this.mContext = context;
            this.inflater=LayoutInflater.from(context);
            this.cursor=cursor;
        }

        @Override
        public View newView (Context context, Cursor cursor, ViewGroup parent) {
                return inflater.inflate(layout, null);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {

            super.bindView(view, context, cursor);

            // Set textviews analogue to this
            TextView name = (TextView) view.findViewById(R.id.label);
            name.setText(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.NAME)));

            // Set the values for other data elements
            // ....

            // Create the imageView
            final int id = cursor.getInt(cursor.getColumnIndex(MySQLiteHelper.UID));
            ImageView imageView = (ImageView) view.findViewById(R.id.imageButton1);

            // load the image from the storage location
            // (a check if the image exists would be nice)
            String mediaStorageFilePath = Environment.getExternalStorageDirectory()
                    + File.separator +"Android"
                    + File.separator +"data"
                    + File.separator + getActivity().getPackageName()
                    + File.separator + "Files"
                    + File.separator + id +".jpg";

            // load the image as a bitmap and set it to the image view
            Bitmap bmp = BitmapFactory.decodeFile(mediaStorageFilePath);
            imageView.setImageBitmap(bmp);

        }
    }
}