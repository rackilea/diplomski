class MyObject {
   public int findIdx(MyObject[] myObjects) {
        if (myObjects != null) {
            for (int i = 0; i <= myObjects.length; i++) {
                if (myObjects[i].equals(this)) {
                    return i;
                }
            }
        }
        return -1;
    }
}