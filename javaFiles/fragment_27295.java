public class PointClass {

    //Set instance variables
    private int pointX;
    private int pointY;

    //Default Constructor - Starts at (0, 0)
    public PointClass() {
        this.pointX = 0;
        this.pointY = 0;
    }

    //Constructor with specified values
    public PointClass(int x, int y){
        this.pointX = x;
        this.pointY = y;
    }

    //Setters
    public void setPointX(int x) { 
        this.pointX = x; 
    }
    public void setPointY(int y) {
        this.pointY = y;
    }

    //Getters
    public int getPointX() { 
        return this.pointX;
    }
    public int getPointY() {
        return this.pointY;
    }

    //toString for use with System.out.println()
    public String toString() {
        return "x = " + this.pointX + " y = " + this.pointY;
    }
}