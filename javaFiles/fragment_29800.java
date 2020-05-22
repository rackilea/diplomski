public Iterator<Type> iterator() {return new ListIterator<Type>();}

private class ListIterator<Type2 extends Comparable<Type2>> implements Iterator<Type2>{
    public Type2 next() {
        // ...
    }
    // ...
    public void prepend(Type2 item){
        // ...
    }

    public void append(Type2 item){
        // ...
    }

    public Type2 first(){
        // ...

    public Type2 pop(){
        // ...