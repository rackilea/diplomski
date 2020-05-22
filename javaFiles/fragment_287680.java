public class A {
  private Image image;

  public A(Image image){
    this.image = image;
  }

  public void methodWhichNeedsCardImage() {
    if(image instanceof CardImage) {
         CardImage cImage = (CardImage) image;
    }
  }
}