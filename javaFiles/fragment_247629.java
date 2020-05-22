class MyListImpl<T> implements MyList {
    Stack<T> mStack;

    public MyListImpl() {
        mStack = new Stack<T>();
    }

    public void addFront(T thing) {
        mStack.push(thing);
    }

    public void remove(int pos) {
        //mStack...
    }

    public void removeEnd() {
        //mStack...
    }

    public T get(int pos) {
        // return mStack...
    }

    public int length() {
        // return mStack... 
    }

    public boolean isEmpty() {
        // return mStack...
    }