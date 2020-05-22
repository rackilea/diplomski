class pair<U,V>{
    U first;
    V second;
    public pair(Class<U> cu, Class<V> cv) {
        try {
            first = cu.newInstance();
            second = cv.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }   
    public pair(U f,V s){
        first = f;
        second = s;
    }
}