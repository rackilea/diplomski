interface Interface<T extends Number>{
    public Vector<? extends Interface<T>> getVector();
}

abstract class C<T extends Number> implements Interface<T>{

    private Vector<C<T>> vector;
    public Vector<? extends Interface<T>> getVector(){
         return this.vector;
    }
}