public class Bomb extends Entity { 
  void whatNow() {
    // do my bomb stuff
    GameEngine.instance().remove(this);
  }
}

public class GameEngine {

  // Declare a gameEntitiesToRemove queue/list

  public void update() {
    for(Entity entity : gameEntities){
       entity.whatNow();
    }
    while(gameEntitiesToRemove.hasNext()){
       gameEntities.remove(gameEntitiesToRemove.pop());
    }
  }

  public void remove(Entity entity) {
    this.gameEntitiesToRemove.add(entity);
  }
}