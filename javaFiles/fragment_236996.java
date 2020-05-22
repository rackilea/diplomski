public class CountdownButton extends Button {
  private boolean isCounting = false;
  private int count;

  private final Runnable countdownRunnable = new Runnable() {
    @Override
    public void run() {
      setText(Integer.toString(count));
      if (count > 0) {
        count--;
        getHandler().postDelayed(countdownRunnable, 1000);
      } else {
        // count reached zero
        isCounting = false;
        setText("boom");
      }
    }
  }

  private final View.OnClickListener onClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      if (isCounting) {
        // stop counting
        isCounting = false;
        getHandler().removeCallbacks(countdownRunnable);
        setText("cancelled");
      } else {
        // start counting
        isCounting = true;
        count = 10;
        countdownRunnable.run();
      }
    }
  }

  public CountdownButton(Context context) {
    super(context);
    setOnClickListener(onClickListener);
  }

  public CountdownButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    setOnClickListener(onClickListener);
  }

  public CountdownButton(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    setOnClickListener(onClickListener);
  }
}