public class Main {
public static void main(String[] args) {
    //create arraylist for each class
    ArrayList<Point> list = new ArrayList<Point>();
    ArrayList<Rectangle> list1 = new ArrayList<Rectangle>();
    ArrayList<Circle> list2 = new ArrayList<Circle>();
    //create random generators
    Random randomNum = new Random();
    Random myGenerator = new Random();
    int i = 0;
    //go through for loop
    while (i < 100){

        int whichArray = myGenerator.nextInt(4) + 1;
        //print out points for whichever random object
        if (whichArray == 1){
            int pointX = 0;
            while (pointX == 0){
                pointX= randomNum.nextInt(41) - 20;
            }
            int pointY = 0;
            while(pointY == 0){
                pointY = randomNum.nextInt(41) - 20;
            }
            if (pointX >= 0 && pointY >= 0){
                Point point = new Point();
                point.setX(pointX);
                point.setY(pointY);
                list.add(point);
                System.out.println(list.toString());
                list.remove(0);
                i++;
            }
        }//end if
        if (whichArray == 2){
            int pointX = 0;
            while (pointX == 0){
                pointX= randomNum.nextInt(41) - 20;
            }
            int pointY = 0;
            while(pointY == 0){
                pointY = randomNum.nextInt(41) - 20;
            }
            int pointRandom = randomNum.nextInt(20) - 20;
            if (pointX >= 0 && pointY >= 0 && pointRandom >= 0){
                Point point = new Point();
                point.setX(pointX);
                point.setY(pointY);

                Point point2 = new Point();
                point2.setX(pointX+pointRandom);
                point2.setY(pointY-pointRandom);

                list1.add(new Rectangle(point, point2));
                System.out.println(list1.toString());
                list1.remove(0);
                i++;
            }

        }//end if
        if (whichArray == 3){
            int pointX = 0;
            while (pointX == 0){
                pointX= randomNum.nextInt(41) - 20;
            }
            int pointY = 0;
            while(pointY == 0){
                pointY = randomNum.nextInt(41) - 20;
            }
            int radius = randomNum.nextInt(41) - 20;
            if (pointX >= 0 && pointY >= 0){
            list2.add(new Circle(new Point(pointX, pointY),radius));
            System.out.println(list2.toString());
            list2.remove(0);
            i++;
            }
        }//end if

    }//end while loop

}//end main


}//end class