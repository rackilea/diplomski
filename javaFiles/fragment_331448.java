public class Square extends Shape ..{

 @Override
 public void displayInformation(){
     System.out.println("Perimeter: " + this.getPerimeter());
            System.out.println("Area: " + this.getArea());
            System.out.println("Average length of sides: " + this.getAverage());
 }

}