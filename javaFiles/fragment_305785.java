public class WrapperA implements Addressable {

  private final A a;

  public WrapperA(A a) {
    this.a = a;
  }

  @Override
  public Address getAddress(){
     return new Address(a.getCity(), a.getStreet(), etc...);
  } 

}