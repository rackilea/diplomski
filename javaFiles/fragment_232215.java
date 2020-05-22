public void run() {
  setup();

  // Now we don't re-declare Paddle 
  Paddle = new GRect(0,HEIGHT - PADDLE_HEIGHT - PADDLE_Y_OFFSET,PADDLE_WIDTH,PADDLE_HEIGHT);
  add(Paddle);
  addMouseListeners();
}