public int compareTo(final Intersection o) {

    double distance = t;
    double distance2 = o.t; // here you use it, potentially causing NPE

    if (o == null) // if o was null, this is never reached
        return 0;

    if (distance == distance2) 
        return 0;


    return distance2 > distance ? -1 : 1;
}