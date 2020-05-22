int oldStamp = array[0].getStamp();
int newStamp = oldStamp + 1;
DataNode<T> old = array[0].getReference();
DataNode<T> newDn = new DataNode<T>(6, old.value);
if (!array[0].compareAndSet(old, newDn, oldStamp, newStamp)) {
     // If this fails, either the stamp, reference, or both have changed.  Try again.
}