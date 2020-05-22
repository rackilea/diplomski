class Someclass{

  @Resource
  private WebService ws;

  public void sendMessage(){

  ws.sendMsg();        
  }
}