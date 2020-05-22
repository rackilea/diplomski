public class BasketballPerformance extends SportPerformance {
  private Integer points;

  //Constructor
  public BasketballPerformance(Attributes attributes)
  {
     this.points = attributes.getValue("Points");
  }

  public getPoints() 
  {
    return this.points;
  }
}