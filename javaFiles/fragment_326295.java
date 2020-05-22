public class Entity{
    double oldX;
    double oldY;
    double x;
    double y;
    public void render(Graphics g, float alpha){
        float estimatedX = x*alpha+oldX*(1-alpha);
        float estimatedY = y*alpha+oldY*(1-alpha);
        g.drawRect((int)estimatedX,(int)estimatedY,1,1);
    }
}