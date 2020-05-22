class Game() {

  World world; //holds state of things in game
  UI ui;
  long time;
  long elapsed; //number of ms since last update

  mainGameLoop() {

    time = System.currentTimeInMillis();

    while (gameRunning()) {
      elapsed = System.currentTimeInMillis() - time;
      time = System.currentTimeInMillis();
      world.update(elapsed); //updates game state
      ui.render(world);      //draws game state to screen
    }

  }
}