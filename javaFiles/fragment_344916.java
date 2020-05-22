//onCreate() ..

AugmentedView augmentedView = new AugmentedView(this);
augmentedView.setOnTouchListener(this);
augmentedView.setCollisionlistener(new Collisionlistener());
augmentedView.setLayoutParams(new LayoutParams(
        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
liveLayout.addView(augmentedView);

}
 ..
public class Collisionlistener {
    public void onCollosion (){
     // write code to handle collosion
    }

}


    // in your AugmentedView

    private Collisionlistener mListener;

    public void setCollisionlistener(Collisionlistener listener){
        mListener = listener;
    }

    public void onDraw(Canvas canvas){
    // your code
    if (collosionDetected && mListener != null) {
        mListener.onCollosion();
    }

    }