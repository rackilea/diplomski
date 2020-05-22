public final synchronized void setField(int field){
    if (0 <= field && field <= MAX_VALUE) {
        this.field = field;
    } else {
        throw new IllegalArgumentException();
    }   
}

//still has all the benefits of setter
public A(int field){
    setField(field);
}

A = new A(-1) //throws IllegalArgumentException