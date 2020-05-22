private final Object[] objects = new Object[5];
private final boolean[] referenced = new boolean[objects.length];
private int clock = 0;

public Object getOrCache(Object obj) {
    for (int i = 0, objectsLength = objects.length; i < objectsLength; i++) {
        Object o = objects[i];
        if (obj.equals(o)) {
            referenced[i] = true;
            return obj;
        }
    }
    while(referenced[clock]) {
        referenced[clock] = false;
        incrClock();
    }
    objects[clock] = obj;
    incrClock();
    return obj;
}

private void incrClock() {
    if (++clock >= objects.length)
        clock = 0;
}