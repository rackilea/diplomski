Long start = 0L, end = 0L;

@Override
public boolean onTouch(View arg0, MotionEvent event) {

    switch (event.getAction()) {
        case MotionEvent.ACTION_UP:
            end = System.currentTimeMillis();
            //do something....
            if(end-start<1003){
                     //do something ....
            }
            return true;
        case MotionEvent.ACTION_DOWN:
            start = System.currentTimeMillis();
            //do something...         
            return true;
    }
}