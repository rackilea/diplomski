import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;


public class House {

    final int BASEWID = 200;
    final int BASEHT = 250;
    final int DOORWID = 40;
    final int DOORHT = 65;
    final int WINHT = 40;
    final int WINWID = 40;

    private Rectangle[] bx = new Rectangle[6]; //base, four windows, doors
    private Line[] ln = new Line[8]; //roof and window cross frames
    private Circle[] cr = new Circle[1]; //doorknob
    private Polygon[] ply = new Polygon[2];
    private Group trGrp = new Group(); //group

    public House(int xOff, int yOff, Pane pane) {
        initHouse();

        setX(xOff);
        setY(yOff);


        pane.getChildren().add(trGrp);
    }


    //Initialize the house components
    public void initHouse() {

        //base of house
        bx[0] = new Rectangle(DOORWID/2, DOORHT+DOORHT/2, BASEWID, BASEHT);
        bx[0].setStroke(Color.BLACK);
        bx[0].setFill(Color.IVORY);

        //door
        bx[1] = new Rectangle(bx[0].getX()+DOORWID+40, bx[0].getY()+DOORHT+120, DOORWID, DOORHT);
        bx[1].setStroke(Color.BLACK);
        bx[1].setFill(Color.POWDERBLUE);

        //window 1
        bx[2] = new Rectangle(bx[0].getX()+DOORWID-10, bx[0].getY()+DOORHT-30, WINWID, WINHT);
        bx[2].setStroke(Color.BLACK);
        bx[2].setFill(Color.LAVENDERBLUSH);

        //window 2
        bx[3] = new Rectangle(bx[0].getX()+DOORWID+90, bx[0].getY()+DOORHT-30, WINWID, WINHT);
        bx[3].setStroke(Color.BLACK);
        bx[3].setFill(Color.LAVENDER);

        //window 3
        bx[4] = new Rectangle(bx[0].getX()+DOORWID-10, bx[0].getY()+DOORHT+50, WINWID, WINHT);
        bx[4].setStroke(Color.BLACK);
        bx[4].setFill(Color.LAVENDER);

        //window 4
        bx[5] = new Rectangle(bx[0].getX()+DOORWID+90, bx[0].getY()+DOORHT+50, WINWID, WINHT);
        bx[5].setStroke(Color.BLACK);
        bx[5].setFill(Color.LAVENDERBLUSH);

        //doorknob
        double crX1 = bx[0].getX() + BASEWID / 2.3;
        double crY = bx[0].getY() + BASEHT + BASEWID / -7;
        double crRad = BASEWID / 60;
        cr[0] = new Circle(crX1, crY, crRad);
        cr[0].setStroke(Color.BLACK);
        cr[0].setFill(Color.FLORALWHITE);

        //house line
        double midX = bx[0].getX() + BASEWID / 2;
        double leftX = bx[0].getX() - BASEWID / 2;
        double rightX = bx[0].getX() + BASEWID + BASEWID / 2;
        double topY = bx[0].getY() - BASEHT / 2;
        double bottomY = bx[0].getY() + BASEHT / 2;
        ln[0] = new Line(midX, topY, leftX, bottomY);
        ln[1] = new Line(midX, topY, rightX, bottomY);

        //top of house
        ply[0] = new Polygon(ln[0].getStartX(),ln[0].getStartY(),
                bx[0].getX(),bx[0].getY(),
                bx[0].getX()+bx[0].getWidth(),bx[0].getY());
        ply[0].getPoints().addAll();
        ply[0].setStroke(Color.BLACK);
        ply[0].setFill(Color.MEDIUMAQUAMARINE);

        //vertical window panes
        ln[2] = new Line(70, 251, 70, 213);
        ln[3] = new Line(170, 251, 170, 213);
        ln[4] = new Line(70, 133, 70, 172);
        ln[5] = new Line(170, 133, 170, 172);

        //horizontal window panes
        ln[6] = new Line(50, 232, 90, 232);
        ln[7] = new Line(150, 232, 190, 232);
        ln[8] = new Line(50, 152, 90, 152);
        ln[9] = new Line(150, 152, 190, 152); 


        trGrp.getChildren().addAll(bx[0], bx[1], bx[2], bx[3], bx[4], bx[5], cr[0], ply[0], ln[2], ln[3], ln[4], ln[5], ln[6], ln[7], ln[8], ln[9]);
    }

    // Get the X Coordinate
    public double getX()
    {
        return trGrp.getLayoutX();
    }

    // Set the X Coordinate
    public void setX(double x)
    {
        trGrp.setLayoutX(x);
    }

    // Get the Y Coordinate
    public double getY()
    {
        return trGrp.getLayoutY();
    }

    // Set the Y Coordinate
    public void setY(double y)
    {
        trGrp.setLayoutY(y);
    }

}