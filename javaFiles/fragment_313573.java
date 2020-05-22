public int getAdjustment(int ptr_idx) {
    int adjust = 0; 
    for (int i = 0; i < event.getPointerCount(); i++) {
        // Get Actual Pointer Index of touch
        int adjustedPointerIndex = event.getPointerId(i);
        // If we've found the current touch's pointer index AND
        // the pointer index doesn't equal the sequential event's
        // pointers
        if ((adjustPointerIndex == ptr_idx) && (i != adjustPointerIndex)) {
            adjust = (adjustPointerIndex - i);
            break;
        }
    } 

    return adjust;
}

// Example Function using getAdjustment(int ptr_idx)
public void handleActionPointerUp(MotionEvent event, int ptr_idx) {
    int adjustment = ptr_idx - getAdjustment(ptr_idx);
    handleInformation(event.getX(adjustment), event.getY(adjustment));
}