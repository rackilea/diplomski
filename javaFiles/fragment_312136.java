public <T extends EventListener> T[] getListeners(Class<T> t) {
Object[] lList = listenerList; 
int n = getListenerCount(lList, t); 
    T[] result = (T[])Array.newInstance(t, n); 
int j = 0; 
for (int i = lList.length-2; i>=0; i-=2) {
    if (lList[i] == t) {
    result[j++] = (T)lList[i+1];
    }
}
return result;   
}