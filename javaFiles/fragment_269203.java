public void run() {

    initializeState();

    while (stillRunning) { // stillRunning is a flag that signals the user wants to exit

      while(isPaused() && stillRunning) { // isPaused is a flag that is set in the if the user selects pause
        try {
          sleep(100);
        } catch (InterruptedException e) {
        }
      }
      if(!stillRunning)
        break;

      Canvas c = null;
      try {
        c = surfaceHolder.lockCanvas(null); // the game uses a Surface view for drawing
        synchronized (surfaceHolder) {
          updateState();  // update game entities - such as remove explosions that are finished, etc.
          handleInput(); // handle user input (key presses, screen touches, etc.)
          updatePhysics(); // collision detection, speed changes due to gravity, etc.
          updateAnimations(); // update which frames need to draw for animating entities
          updateSound(); // start/stop any sounds required by new game state/events
          updateVideo(c); // draw the next frame of video
        }
      } finally {
        // do this in a finally so that if an exception is thrown
        // during the above, we don't leave the Surface in an
        // inconsistent state
        if (c != null) {
          surfaceHolder.unlockCanvasAndPost(c);
        }
      }
    }
  }