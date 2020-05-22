public enum Sort{
  New("?sort=new"),
  Rising("?sort=rising"),      
  ThisWeek("?sort=thisweek");


  private String urlComponent;
  public Sort(String urlComponent) {this.urlComponent = urlComponent;)
  public getUrlComponent() {return this.urlComponent;}
}