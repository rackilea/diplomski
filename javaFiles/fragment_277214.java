for (int i = 0; i < arrayList.size(); i ++) {
    int oldVal = arrayList.get(i);
    if (oldVal == 2) {
        int newVal = oldVal + 1;
        arrayList.set(i, newVal);
    } else {
        continue;
    }
}