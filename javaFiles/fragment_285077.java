public class delaunay extends Applet implements Runnable {

    public void paint( Graphics g ) {
        displaytri(g, po[eee],arr[0].p1,arr[0].p2);
    }
    public void displaytri(Graphics g, Point v1, Point v2, Point v3) { 
        g.drawLine(v1.x,v1.y,v2.x,v2.y);
        g.drawLine(v2.x,v2.y,v3.x,v3.y);
        g.drawLine(v3.x,v3.y,v1.x,v1.y);        
    }
}