Bin bin = bins.get(index);
while (bin == null) {
    bin = new Bin();
    if (!bins.compareAndSet(index, null, bin)) {
        // some other thread already set the bin in the meantime
        bin = bins.get(index);
    }
}
// use bin as usual