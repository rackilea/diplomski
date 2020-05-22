public class PassengerData{

  //add this property
  private boolean isMatched = false;

  void setMatched(boolean matched){
        this.isMatched = matched;
  }

  boolean isMatched(){
       return isMatched;
  }

}