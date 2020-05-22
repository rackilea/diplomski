Comparable[] comparableList= getStore();
for(Comparable p : comparableList) {
    if(item.compareTo(p)==0) {
        return true;
    }
    if(item.compareTo(p)<0) {
        return false;
    }
}
return false;