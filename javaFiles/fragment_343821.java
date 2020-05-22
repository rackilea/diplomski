int count = 0;
int limit = 0;
for (int i : sortedArray) {
    int diff = i - maxAvg;
    if (limit + diff < 0) {
        limit += diff;
        count++
    } else {
        break;
    }
}
System.out.println(count);