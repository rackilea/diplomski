float touched_x, touched_y; 
boolean touched = false; 

@Override public boolean onTouchEvent(MotionEvent event) { 
    touchCounter++; 
    touched_x = event.getX(); 
    touched_y = event.getY(); 
    int action = event.getAction(); 
    switch (action) { 
        case MotionEvent.ACTION_DOWN: 
            touched = true; 
            break; 
        case MotionEvent.ACTION_MOVE: 
            touched = true; 
            break; 
        case MotionEvent.ACTION_UP: 
            touched = false; 
            break; 
        case MotionEvent.ACTION_CANCEL: 
            touched = false; 
            break; 
        case MotionEvent.ACTION_OUTSIDE: 
            touched = false; 
            break; default: 
    } 
    return true; 
}