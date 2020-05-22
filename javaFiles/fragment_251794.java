public class view  {

  static int n;
  model Model;

  private View(){
     Logger logger = new Logger(this);
     Model = new model();
     Model.setObserver(logger);
  }

  private void doIt(){

    Model.show(5);
    System.out.println("The value is "+n);
  }

  public static void main(String args[]){
      new View().doIt();
  }
}