public class Duck() {
  private String color;
  private int numLeg ;
  private boolean haveWings ;

  public Duck(String aColor, int aNumLeg, boolean hasWings) {
    color=aColor;
    numLeg=aNumLeg;
    haveWings=hasWings;
  }

  public Duck() {
    this("", 2, true); // a little trick for lazy man ;)
  }
}