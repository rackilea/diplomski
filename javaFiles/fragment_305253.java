public class Subcl extends Supcl.Inner {
  public Subcl() {
    //assuming there is a no-argument constructor Supcl()
    //this only works in one statement so the call to super is still 
    //part of the first statment in this constructor
    new Supcl().super(34); //will call Inner(34)
  }

  public Subcl( Supcl sup) {
    sup.super(34);  //will call Inner(34)
  }
}