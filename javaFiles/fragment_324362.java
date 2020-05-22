public int compareTo(Passenger other) {
    if (this.isDisability() ^ other.isDisability()) { //use an XOR
        return this.isDisability() ? 1 : -1; //1 for us, -1 for other
    }
    //compare #getClase
    int clase = -Integer.compare(this.getClase(), other.getClase()); //invert
    if (clase == 0) {
        //compare arrival times if clase is equal
        //normalize to -1, 1 (0 excluded in OP)
        return this.getArrivalTime() < other.getArrivalTime() ? 1 : -1;
    }
    return clase > 0 ? 1 : -1; //normalize to -1, 0, 1
}