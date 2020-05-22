public class Triangle extends Shape implements whatyouwant {


 @Override 
 public void displayInformation(){
   System.out.println("Perimeter: " + this.getPerimeter());
   System.out.println("Area: " + this.getArea());
 }

}