public class MyManager extends NegativeMarginVerticalFieldManager {
    protected void paint(Graphics g) {
        for (int i = 1; i < getFieldCount(); i++) {
            paintChild(getField(i), g);
        }

        if (getFieldCount() > 0)
           paintChild(getField(0), g);
    }
}