private List<GameObject> mObjList = /* whatever */;
private final Object mListMutex = new Object();

// snip...

synchronized (mListMutex) {
    for (GameObject obj : mObjList) {
        // do your thang
    }
}

// snip...
public void click(int x, int y) {
    GameObject obj = new GameObject(x, y);
    synchronized (mListMutex) {
        mObjList.add(obj);
    }
}