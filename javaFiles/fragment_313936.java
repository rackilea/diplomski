...

private int comparisons = 0;
private int swaps = 0;

public ArrayList<Integer> quickSort(ArrayList<Integer> data , int low , int high)
{
    ...
}

public printCounters()
{
    System.out.println("Quick S swaps :   " + swaps);
    System.out.println("Quick S comparisons :   " + comparisons);
}

....

someObj.quickSort(data, 0, data.size() - 1); // sort the list
someObj.printCounters(); // print the counters