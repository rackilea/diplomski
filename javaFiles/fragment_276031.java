public class Worker{

  String name;
  int number;

  private static int totalCount=0;


  public Worker(String N){

     name=N;
     totalCount++;
     number = totalCount;
  }

  public String numberOfTime(){
      return name +", "+ number; 
  }
}