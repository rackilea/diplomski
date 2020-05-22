View view = this.getWindow().getDecorView();
view.post( new Runnable() {
    @Override
    public void run() {
         width  = view.getMeasuredWidth();
         height = view.getMeasuredHeight();
         bitmap = Bitmap.createBitmap(height, width, Bitmap.Config.ARGB_8888 );
         canvas = new Canvas(bitmap); 
    }
});