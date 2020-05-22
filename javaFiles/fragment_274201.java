public class Location {
    private double x;
    private double y;

    public Location(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x=x;
    }

    public void setY(double y){
        this.y=y;
    }

    public String toString(){
        return "Location: x= "+getX()+" ; y= "+getY();
    }

    public double getDistance(Location L){
        double x1=L.getX();
        double y1=L.getY();
        return (Math.sqrt((Math.pow((x-x1),2))+(Math.pow((y-y1), 2))));
    }
}

public class Target{
    private Location loc;
    private double speed;
    private String type;
    private boolean threat;
    private static int count = 0;

    public Target(double x, double y, double speed){
        loc = new Location(x, y);
        this.speed = speed;
        if(speed<500)
            type="Helicopter";
        else type="Jet";
        threat = false;
        count++;
    }

    public String getType(){
        return type;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public boolean isThreat(Location L){
        if(loc.getDistance(L)<100){
            threat=true;}
        else threat=false;
        return threat;
    }

    public String toString(){
        return "Target is " + getType() + ", speed= " + getSpeed() + "mph, [Location: x=" + loc.getX()+ "; y=" + loc.getY() + "]";
    }
}