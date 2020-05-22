import java.awt.Color;

public class ControlModel {

    protected boolean isAnimated;

    protected int jpanelWidth;
    protected int outerCircle;
    protected int innerCircle;
    protected int penLocation;
    protected int penSize;

    protected Color penColor;
    protected Color backgroundColor;

    public ControlModel() {
        init();
        this.penColor = Color.BLUE;
        this.backgroundColor = Color.WHITE;
    }

    public void init() {
        this.jpanelWidth = 512;
        this.outerCircle = 1000;
        this.innerCircle = 520;
        this.penLocation = 400;
        this.penSize = 2;
        this.isAnimated = true;
    }

    public int getOuterCircle() {
        return outerCircle;
    }

    public void setOuterCircle(int outerCircle) {
        this.outerCircle = outerCircle;
    }

    public int getInnerCircle() {
        return innerCircle;
    }

    public void setInnerCircle(int innerCircle) {
        this.innerCircle = innerCircle;
    }

    public int getPenLocation() {
        return penLocation;
    }

    public void setPenLocation(int penLocation) {
        this.penLocation = penLocation;
    }

    public int getPenSize() {
        return penSize;
    }

    public void setPenSize(int penSize) {
        this.penSize = penSize;
    }

    public boolean isAnimated() {
        return isAnimated;
    }

    public void setAnimated(boolean isAnimated) {
        this.isAnimated = isAnimated;
    }

    public Color getPenColor() {
        return penColor;
    }

    public void setPenColor(Color penColor) {
        this.penColor = penColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getJpanelWidth() {
        return jpanelWidth;
    }

    public int getJpanelHeight() {
        return jpanelWidth;
    }

}