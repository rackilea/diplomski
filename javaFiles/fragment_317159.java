public class NewBox extends Box{ 

  public NewBox(String name) {
    super(name);
  }

  public void calculateVolume(int length, int width, int height){ 
    System.out.println("Volume = " + (length*width*height));
  }
}