public class BroadCastEvent{
  private boolean isCompleted;

  BroadCastEvent(boolean completed){
     this.isCompleted = completed;
  }

  //getter
  public boolean isCompleted(){
     return this.isCompleted;
  }
}