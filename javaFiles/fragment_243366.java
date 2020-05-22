@Override
protected void compute() {
    if (mLength <= 300) {//do work directly
        computeDirectly();
        return;
    }

    int split = mLength / 2;
    invokeAll(
        new MultiThreading(mStart, split), 
        new MultiThreading(mStart + split, mLength - split));
}