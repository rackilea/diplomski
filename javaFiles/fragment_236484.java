public int binSearch(int empID)
{
    int first = 0;
    int last = empCount - 1;
    boolean found = false;
    int mid = 0;

    while (first <= last && !found)
    {
        mid = (first + last) >>> 1; // overflow prevention

        if (empNums[mid] == empID) {
            found = true;
        } else if (empNums[mid] < empID) {
            first = mid + 1;
        } else {
            last = mid - 1;
        }
    }
    return found ? mid : -1;
}