public class MasterCreator implements Creator<Master>{
  private int nrOfWorkers, nrOfMessages, nrOfElements;
  private ActorRef listener;
  public MasterCreator(int nrOfWorkers, int nrOfMessages, int nrOfElements, ActorRef listener){
    this.listener = listener;
    this.nrOfElements = nrOfElements;
    this.nrOfMessages = nrOfMessages;
    this.nrOfWorkers = nrOfWorkers;
  }

  public Master create(){
    return new Master(nrOfWorkers, nrOfMessages, nrOfElements, listener);
  }
}