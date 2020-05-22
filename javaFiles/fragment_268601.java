public class GameEngine {
  // an instance variable, declared outside of the methods.
  // its lifetime equals that of the game engine instance
  private GameEngineCallback gameEngineCallback;

  public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
    this.gameEngineCallback = gameEngineCallback;
  }

  // later on, the engine can call upon the callback to do stuff
  public void startGame() {
    this.gameEngineCallback.start();
  }
}