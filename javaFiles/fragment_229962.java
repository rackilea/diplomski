public void add(Test t) {
    testlist.add(t);
    int index0 = testlist.size() - 1;
    int index1 = index0;
    fireIntervalAdded(this, index0, index1);
}

public void remove(Test t) {
    int index0 = ... // this will depend on where t was in the testlist
    int index1 = ... // ditto
    testlist.remove(t);
    fireIntervalRemoved(this, index0, index1);
}