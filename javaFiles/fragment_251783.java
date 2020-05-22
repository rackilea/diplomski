// original compareTo implementation with bug marked

@Override
public int compareTo(Object o) {
    int output = 0;
    if (boeking.compareTo(((Ticket) o).getBoeking())==0)
    {
        if(this.equals(o))
        {
            return output;
        }
        else return 1; // BUG!!!! See explanation below!
    }
    else output = boeking.compareTo(((Ticket) o).getBoeking());
    return output;
}