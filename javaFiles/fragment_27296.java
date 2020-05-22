public class PointTest {

    public static void main(String[] args){
        System.out.println("Lab1 Point");
        System.out.println("January 17, 2014");
        System.out.println();

        PointClass point1 = new PointClass();         //set point1 as no argument 
        PointClass point2 = new PointClass(11, 24);  // set point2 as argument with x and y

        System.out.println("Point1: " + point1);  //display point1 from toString method
        System.out.println("Point2: " + point2); //display point2 from toString method
        System.out.println();

        point1.setPointX(35);

        System.out.println("Point1: " + point1);  
        System.out.println("Point2: " + point2); 
        System.out.println();

        point2.setPointY(13);

        System.out.println("Point1: " + point1);  
        System.out.println("Point2: " + point2);
    }

}