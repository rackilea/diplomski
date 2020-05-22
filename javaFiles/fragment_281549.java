/** A method to determine if area1 is entirely contained within area2. */
public boolean doAreasEnclose(Area area1, Area area2) {
    Area temp = new Area(area1);
    temp.subtract(area2);
    Rectangle r = temp.getBounds();
    boolean enclosed = r.getWidth()==0 && r.getHeight()==0;
    return enclosed;
}