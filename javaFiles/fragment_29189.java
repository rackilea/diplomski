ArrayList<Vector3> fingerTips = new ArrayList<Vector3>();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int points = event.getPointerCount();

        // Check if it's an event that a finger
        // was removed, if so, set removedPoint
        int removedPoint = -1;
        final int action = event.getAction() & MotionEvent.ACTION_MASK;

        if(action == MotionEvent.ACTION_POINTER_UP || action == MotionEvent.ACTION_UP)
            removedPoint = (action & MotionEvent.ACTION_POINTER_INDEX_MASK) 
                    >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;


        String out = "==========\n";

        fingerTips.clear();

        for(int i = 0; i < points; i++){
            // Find out pointer ID
            int pointerID = event.getPointerId(i);
            if(pointerID == MotionEvent.INVALID_POINTER_ID){
                out += "\tPoint "+pointerID+" INVALID\n";
                continue;
            }

            // Check if it's the removed finger
            if(removedPoint == i){
                out += "\tPoint "+pointerID+" REMOVED\n";
                continue;
            }

            out += "\tPoint "+pointerID+"\t("+event.getX(i)+", "+event.getY(i) + ")\n";
            fingerTips.add( new Vector3(event.getX(i), event.getY(i), pointerID) );
        }

        Log.i(TAG, out);

        // Send touches to SurfaceView
        chwaziViewGL.onUpdateFingerTips(fingerTips);

        return true;
    }