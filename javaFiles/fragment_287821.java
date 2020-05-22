static List<Point> fillp(List<Double> listx){
    List<Point> listp = new ArrayList<>();
    for(int i = 0; i < listx.size(); i++) {
    Point p = new Point( listx.get(i), function(listx.get(i)) );
        listp.add( p );
    }
    return listp;
}