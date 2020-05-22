//Rectangle class
class Rectangle{
  private int length;
  private int width;

  Rectangle(){
    this.length=1; // assuming default length=1
    this.width=1; // assuming default width=1
  }

  Rectangle(int length, int width){
    this.length=length; 
    this.width=width; 
  }

int area(){
   return length*width;
}
int perimeter(){
  return 2*(length+width);
}
}


// test class

public class TestRectangle{
    public static void main(String args[]){
        Rectangle r1= new Rectangle();
        System.out.println("Area of r1: "+ r1.area());
        Rectangle r2= new Rectangle(2,3);
        System.out.println("Perimetr of r2: "+ r2.perimeter());
    }
}