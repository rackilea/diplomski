public class Point implements Comparable<Point> {
    private double x;
    private double y;
    private double z;
    private String name;

    public Point( final double x, final double y, final double z, final String name ) {
        setX( x );
        setY( y );
        setZ( z );
        setName( name );
    }

    public boolean equals( final Point point ){
        final boolean isEqual =
                (   this.getX() == point.getX()
                &&  this.getY() == point.getY()
                &&  this.getZ() == point.getZ() )
            ||  (   this.getName().equals( point.getName() ) );
    //  System.out.println( this.toString() + " == " + point.toString() + " = " + isEqual );
        return isEqual;
    }

    /// @return the x
    public double getX() { return x; }
    /// @return the y
    public double getY() { return y; }
    /// @return the z
    public double getZ() { return z; }
    /// @return the name
    public String getName() { return name; }
    /// @param x the x to set
    public void setX(final double x) { this.x = x; }
    /// @param y the y to set
    public void setY(final double y) { this.y = y; }
    /// @param z the z to set
    public void setZ(final double z) { this.z = z; }
    /// @param name the name to set
    public void setName(final String name) { this.name = name; }

    public String toString() {
        final StringBuffer str = new StringBuffer();
        str.append( '(' );
        str.append( getX() );
        str.append( ',' );
        str.append( getY() );
        str.append( ',' );
        str.append( getZ() );
        str.append( ',' );
        str.append( getName() );
        str.append( ')' );
        return str.toString();
    }

    public double distanceFromOriginSquared(){
        return this.getX()*this.getX()
                + this.getY()*this.getY()
                + this.getZ()*this.getZ();
    }

    @Override
    public int compareTo( final Point point ) {
        if ( this.getName().equals( point.getName() ) )
            return 0;
        final double td = this.distanceFromOriginSquared();
        final double pd = point.distanceFromOriginSquared();
        if ( td < pd ) return -1;
        if ( td > pd ) return +1;
        if ( this.getX() < point.getX() ) return -1;
        if ( this.getX() > point.getX() ) return +1;
        if ( this.getY() < point.getY() ) return -1;
        if ( this.getY() > point.getY() ) return +1;
        return 0;   
    }
}