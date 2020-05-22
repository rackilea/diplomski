void onCreate(Bundle savedInstanceState) {

    // inflate the XML with setContentView(), create your Bitmap, etc

    sv = (SurfaceView)findViewById(R.id.surview);
    sv.addCallback(new SurfaceHolder.Callback() {
        @Override
        void surfaceCreated(SurfaceHolder holder) {
            Canvas can;
            try {
                can = holder.lockCanvas(null);
                synchronized(holder) {
                    can.drawBitmap(bm, 0, 0, null);         
                }
            } finally {
                if(can != null) {
                    holder.unlockCanvasAndPost(can);
            }
        }});

    // the rest of onCreate()
}