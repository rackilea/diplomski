public String getNext(String uid) {
    int idx = myList.indexOf(uid);
    if (idx < 0 || idx+1 == myList.size()) return "";
    return myList.get(idx + 1);
}

public String getPrevious(String uid) {
    int idx = myList.indexOf(uid);
    if (idx <= 0) return "";
    return myList.get(idx - 1);
}