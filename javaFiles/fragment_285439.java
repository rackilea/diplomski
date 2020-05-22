public class GL2ShapeDrawer extends ShapeDrawer {
    private GL2 gl;
    public GL2ShapeDrawer(GL2 gl) {
        this.gl = gl;
    }
    public void drawRectangle(Rectangle r, Vec3 position, float angle) {
        ... drawing code ...
    }
    public void drawCircle(Circle c, Vec3 position, float angle) {
        ... drawing code ...
    }
}