Iterator<T> itr = mySet.iterator();
int nth = y;
T value = null;

for(int i = 0; itr.hasNext(); i++) {
    value = itr.next();
    if (i == nth) {
        break;
    }
}