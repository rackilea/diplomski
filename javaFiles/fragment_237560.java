class Coordinates{
    private double x, y;    

    public Coordinates(double x, double y) {
        this.x= x;
        this.y= y;
    }

     // Overriding equals() to compare two Complex objects
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Coordinates)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members 
        Coordinates c = (Coordinates) o;

        // Compare the data members and return accordingly 
        return Double.compare(x, c.x) == 0
                && Double.compare(y, c.y) == 0;
    }
}