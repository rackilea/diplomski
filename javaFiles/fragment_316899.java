@Override
public boolean onTouchEvent(MotionEvent event) {
    Toast.makeText(context, "Picture taken", Toast.LENGTH_SHORT).show();
    //System.gc(); tried this because it was suggested in a stackoverflow question but it didn't help.

    switch(event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            // A pressed gesture has started, the motion contains the initial starting location
            break;

        case MotionEvent.ACTION_UP:
            // A pressed gesture has finished, the motion contains the final release location 
            // as well as any intermediate points since the last down or move event.

            mCamera.takePicture(null, mPicture, mPicture);

            break;

        default:
            break;
    }

    return true; //processed
}