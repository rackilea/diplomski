/* Vector instantiation goes here */

boolean keepRunningFlag = true;
while(keepRunningFlag) {
    if (!vector.isEmpty()) {
        Object o = vector.remove(vector.size() - 1);
        keepRunningFlag = doStuffWithVectorElement(o);
    }
}