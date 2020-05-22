int i = 0;
int j = 0;

while (j < A.size()) {
    if (A.get(j).compareTo(x) > 0) {
        j++;
    } else if (i < j) {
        A.set(i++, A.get(j++));
    } else {
        i++;
        j++;
    }
}
int oldSize = A.size();
int newSize = oldSize - j + i;
A.subList(newSize, oldSize).clear();