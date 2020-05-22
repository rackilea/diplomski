final Vector<Double> vector = new Vector<Double>();
vector.add(1.0);
vector.add(2.0);

// Not thread safe!  If another thread modifies "vector" during the loop, then
// a ConcurrentModificationException will be thrown.
for (Double num : vector) {
    System.out.println(num);
}

// You can try this as a quick fix, but it might not be what you want:
synchronized (vector) {    // "vector" must be final
    for (Double num : vector) {
        System.out.println(num);
    }
}