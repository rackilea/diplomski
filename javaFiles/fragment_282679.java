public class ShapeTest{
    public static void main(String[] args){
        Color color = new Color(50, 100, 150);
        Point point = new Point(50,50);
        Shape[] theShape = {
                new Rectangle(color, point),
                new Triangle(color, point),
                new Eclipse(color, point)
        };
        Shape shapechoice;
        Random select = new Random();
        for (int i = 0; i < 10; i ++)
        {
            shapechoice = theShape[select.nextInt(theShape.length)];
            System.out.println("The " + (i + 1) + "type you chose is: " +shapechoice.Type());;
        }
    }
}