public class DemoRelativeLayout extends RelativeLayout
{
ArrayList<ActivityTest.Ponto> pontos;
float cntrX,cntrY;
public DemoRelativeLayout(Context context) {
    super(context);
}

public DemoRelativeLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
}

public DemoRelativeLayout(Context context, AttributeSet attrs, intdefStyleAttr) {
    super(context, attrs, defStyleAttr);
}

@Override
protected void dispatchDraw(Canvas canvas) {
    super.dispatchDraw(canvas);
    if(pontos != null){
        Paint p = new Paint();
        p.setColor(Color.RED);
        for (ActivityTest.Ponto pt : pontos){
            float x = (float)pt.getX() + cntrX;
            float y = (float)pt.getY() + cntrY;
            canvas.drawCircle(x,y,5,p);
        }

    }

}

public void drawCircle(ArrayList<ActivityTest.Ponto> pp,float x,float y){
    cntrX = x;
    cntrY = y;
    pontos = pp;
}
}