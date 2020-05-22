class Dynamic <T extends Object> {
    T t;

    T getEntity(Object e) {
        return t;
    }

    void setEntity(T e) {
       this.t = e;
    }
}