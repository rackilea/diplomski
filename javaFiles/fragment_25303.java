public void union(Circle other) throws Exception { 
    synchronized (Circle.class) {
       if (!checkInv(other.getX(),other.getY(),other.getRadius())) {
           throw new Exception("Illegal circle: " + other); 
       }
       setRadius(calculateUnionRadius(_x,_y,_radius,other.getX(),other.getY(),other.getRadius())); 
    } 
}