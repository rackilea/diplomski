@ManagedBean(name="chartBean")
@YOURSCOPE (might be Request, Session etc...)
public class ChartBean implements Serializable{
  Chart chart;

  //you should initialize your bean in the constructor, or somewhere in the class, like
  public ChartBean(){
    ...
    Chart = new Chart();
    ...
  }

  public Chart getChart(){
    return this.chart;
  }
}