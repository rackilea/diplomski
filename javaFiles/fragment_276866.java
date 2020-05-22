public static ArrayList<Vehicle> quickSort(ArrayList<Vehicle> list)
{
    if (list.isEmpty()) 
        return list; // start with recursion base case
    ArrayList<Vehicle> sorted;  // this shall be the sorted list to return, no needd to initialise
    ArrayList<Vehicle> smaller = new ArrayList<Vehicle>(); // Vehicles smaller than pivot
    ArrayList<Vehicle> greater = new ArrayList<Vehicle>(); // Vehicles greater than pivot
    Vehicle pivot = list.get(0);  // first Vehicle in list, used as pivot
    int i;
    Vehicle j;     // Variable used for Vehicles in the loop
    for (i=1;i<list.size();i++)
    {
        j=list.get(i);
        if (j.compareTo(pivot)<0)   // make sure Vehicle has proper compareTo method 
            smaller.add(j);
        else
            greater.add(j);
    }
    smaller=quickSort(smaller);  // capitalise 's'
    greater=quickSort(greater);  // sort both halfs recursively
    smaller.add(pivot);          // add initial pivot to the end of the (now sorted) smaller Vehicles
    smaller.addAll(greater);     // add the (now sorted) greater Vehicles to the smaller ones (now smaller is essentially your sorted list)
    sorted = smaller;            // assign it to sorted; one could just as well do: return smaller

    return sorted;
}