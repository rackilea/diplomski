public class MySpecialWrapper{
  private final BigPojo delegate;

  public MySpecialWrapper(BigPojo pojo){
    this.delegate = pojo;
  }

  public int hashCode(){
    //insert special impl here.
  }

  public boolean equals(Object o){
    //insert special impl here.
  }
}