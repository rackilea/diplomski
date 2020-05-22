public boolean onTouchEvent(MotionEvent event) {

        final int action = event.getAction();

        float x = event.getX();
        float y = event.getY();

        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                for(CanvasItem itm : mItems){
                     //if item istouched
                     if(itm.isHit(x, y)){
                        /* Logic can go here to alter any properties */
                     }
                 }
         }
    }