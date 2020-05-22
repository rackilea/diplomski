class SortbyScore implements Comparator<Client> 
{ 
    // Used for sorting in descending order(bigger to smaller) of  score
    public int compare(Client a, Client b) 
    { 
        return b.score - a.score; 
        // if you want ascending order (smaller to bigger)
        // return a.score - b.score; 
    } 
}


....
// in your main method.. 
List<Client> clientList = new ArrayList<>();
...
/// insert data into clientList.

// sort client list;
Collections.sort(clientList , new SortbyScore());

// now client list will contain the sorted data.
System.out.println("Sorted: " clientList);
// Better use for-loop and print each element.