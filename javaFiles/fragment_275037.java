if (vector != null) {
 synchronized(vector) {
for (int i = 0; i < 10; i++) {
        vector.add(Thread.currentThread().getName());
    }
    for (int i = 0; i < vector.size(); i++) {
        System.out.println(vector.get(i) + " Hash Code "
                + vector.hashCode());
    }
    // clear the vector for values already printed
    vector.clear();
}
}