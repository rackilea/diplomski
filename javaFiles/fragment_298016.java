for (int indexI = 0; indexI < objects.size(); indexI++) {
    GameObject object1 = objects.get(indexI);
    for (int indexJ = indexI + 1; indexJ < objects.size(); indexJ++) {
       GameObject object2 = objects.get(indexJ);
       object1.collisionHandling(object2);
    }
}