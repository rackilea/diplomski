public class PositionHolder {
    private double xPos;
    private double yPos;
    private int point;
    private boolean visited;

    public PositionHolder(int pointNumber){
        setxPos(100 * Math.random());
        setyPos(-100 * Math.random());
        setPoint(pointNumber);
        setVisited(false);
    }  

    public double getxPos() {
        return xPos;
    }  

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }  

    public boolean isVisited() {
        return visited;
    }  

    public void setVisited(boolean visited) {
        this.visited = visited;
    } 
}