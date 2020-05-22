synchronized (dependencies[i]) {
    if (dependencies[i].done != true) {
        ...
        dependencies[i].wait();
        ...
    }
}
done = true;
notify();