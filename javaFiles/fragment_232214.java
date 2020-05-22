public void run() {
  setup();

  // notice that you re-declare Paddle here!
  GRect Paddle = new GRect(0,HEIGHT - PADDLE_HEIGHT - PADDLE_Y_OFFSET,PADDLE_WIDTH,PADDLE_HEIGHT);
  add(Paddle);
  addMouseListeners();
}