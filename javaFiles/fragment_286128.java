public class TranslateAnim extends TranslateAnimation{

    public TranslateAnim(float fromXDelta, float toXDelta, float fromYDelta,
            float toYDelta) {
        super(fromXDelta, toXDelta, fromYDelta, toYDelta);
        // TODO Auto-generated constructor stub
    }

    private long mElapsedAtPause=0;
    private boolean mPaused=false;

    @Override
    public boolean getTransformation(long currentTime, Transformation outTransformation) {
        if(mPaused && mElapsedAtPause==0) {
            mElapsedAtPause=currentTime-getStartTime();
        }
        if(mPaused)
            setStartTime(currentTime-mElapsedAtPause);
        return super.getTransformation(currentTime, outTransformation);
    }

    public void pause() {
        mElapsedAtPause=0;
        mPaused=true;
    }

    public void resume() {
        mPaused=false;
    }
}