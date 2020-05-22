Display.getDefault().timerExec(100, new Runnable() {
    @Override
    public void run() {
      canvas.redraw();

      // Run again - TODO add logic to stop after correct number of moves
      Display.getDefault().timerExec(100, this);
    }
   });