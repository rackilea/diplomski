public class Pacman extends View {
  float mSweepAngle;
  ...
  //include constructors
  //override onMeasure
  ...

  /* Here we override onDraw */
  @Override
  protected void onDraw(final Canvas canvas) {
    Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF oval = new RectF(canvas.getClipBounds());
    canvas.drawArc(oval, 0, mCurrAngle, true, p);
  }

  /* Here we define our nested custom animation */
  public class OpenPacman extends Animation {
    float mStartAngle;
    float mSweepAngle;

    public OpenPacman (int startAngle, int sweepAngle, long duration) {
      mStartAngle = startAngle;
      mSweepAngle = sweepAngle;
      setDuration(duration);
      setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
      float currAngle = mStartAngle + ((mSweepAngle - mStartAngle) * interpolatedTime);
      Pacman.this.mCurrAngle = -currAngle; //negative for counterclockwise animation.
    }
  }
}