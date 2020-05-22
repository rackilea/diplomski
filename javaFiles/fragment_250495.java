public class Seat{

    private int index;  //-1 if not available, > 0 otherwise
    private boolean available;

    /** Creates an available seat with index i. i > 0. */
    public Seat(int i){
        index = i;
        available = true;
    }

    /** Creates a non-available seat. */
    public Seat(){
        index = -1;
        available = false;
    }

    /** Return a string representation of this Seat. Its index if available, - otherwise */
    public String toString(){
        if(available) return index + "";
        else return "-";
    }
}