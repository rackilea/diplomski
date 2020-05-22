editText.addTextChangedListener(
 new TextWatcher() {
  @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
  @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

  private Timer timer = new Timer();
  private final long DELAY = 500; // milliseconds

  @Override
  public void afterTextChanged(final Editable s) {
   timer.cancel();
   timer = new Timer();
   timer.schedule(
    new TimerTask() {
     @Override
     public void run() {
      // refresh your list
     }
    },
    DELAY
   );
  }
 }
);