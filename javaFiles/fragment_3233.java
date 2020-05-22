for (Object obj1 in World.trackedObjects()) {
    for (Object obj2 in World.trackedObjects()) {
        if (obj1.influences(obj2)) {
            obj1.update(); obj2.update();
        }
    }
}