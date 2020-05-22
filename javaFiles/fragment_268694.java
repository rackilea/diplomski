public class PointerPath extends Path2D.Double {

    public PointerPath() {
        moveTo(1, 1);
        lineTo(150, 1);
        lineTo(198, 100);
        lineTo(150, 198);
        lineTo(1, 198);
        lineTo(50, 100);
        closePath();
    }

}