public class CirclesView extends View {

    public Circle circleR;
    public Circle circleG;
    public Circle circleB;

    public CirclesView(Context context) {
        super(context);

        circleR = new Circle(200, 255, 0, 0);
        circleG = new Circle(500, 0, 255, 0);
        circleB = new Circle(800, 0, 0, 255);
    }

    @Override
    protected void onDraw(Canvas canvas){
        circleR.draw(canvas);
        circleG.draw(canvas);
        circleB.draw(canvas);
    }
}