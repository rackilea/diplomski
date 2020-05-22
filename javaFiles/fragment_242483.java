button.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            anim.setVisible(true,true);
            anim.start();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
         anim.stop(); //perform your animation when button is released
         animup.setVisible(true,true);
         animup.start();
       }
    }
};