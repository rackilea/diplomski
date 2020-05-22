// Async Action that's triggered when a user clicks "Start Game".
  // Runs logic in separate gameLogicContext thread pool and asynchronously returns a response without blocking of Play's default thread pool.
  def startGame = Action.async { implicit request =>

    Future {

      // ... your game logic here. This will be run in gameLogicContext

      Ok("Game started in separate thread pool") // http response

    }(Contexts.gameLogicContext) // the thread pool the future should run in.

  }