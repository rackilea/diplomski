Thread t = new Thread() {
    for (int i=pos;i<mImageIds.length;i++){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                selectedImage.setImageResource(mImageIds[i]);
        }};);
    try {
        wait(1000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}};

play.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        t.start();
    }   
});