new Handler().postDelayed(new Runnable(){   
@Override
public void run() {
    HorizontalScrollView hsv = (HorizontalScrollView) findViewById(R.id.hsv1);
        hsv.scrollTo(hsv.getRight(), hsv.getTop());
    }       

},100L);