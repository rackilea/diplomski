package beans;

public class Bean1 implements java.io.Serializable {

  private String a;
  private String b;

  public Bean1(){}

  public void setA(String a){
    this.a = a;
  }

  public void setB(String b){
    this.b = b;
  }

  public String getA(){
    return this.a;
  }

  public String getB(){
    return this.b;
  }

}