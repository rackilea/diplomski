synchronized (originalList) {
    originalList.add(something);
}
synchronized (originalList) {
    int index = originalList.indexOf(something);
}