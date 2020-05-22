while (itemQ.isEmpty()) {
    wait();
}
Integer item = itemQ.remove(0);
notify();
return item;