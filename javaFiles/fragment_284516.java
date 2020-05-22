import java.awt.Graphics;

public class Triangle extends ClosedShape{

    public Triangle(int x, int y, int base, int height){
        super(true, 3);

        setWidth(base);
        setHeight(height);

        int [] arrayX = new int[3];
        arrayX[0] = x;
        arrayX[1] = (x+(width/2));
        arrayX[2] = (x+width);

        int [] arrayY = new int[3];
        arrayY[0] = y;
        arrayY[1] = (y-height);
        arrayY[2] = y;

        setXYCoords(arrayX, arrayY);

    }

    public double Area(){
                return 0;
    }

    public double Perimeter(){
        return 0;
    }


}