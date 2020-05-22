public E get3() {
    E obj = construct();
    Example<E> objAsEx = obj;
    objAsEx.specialOp();
    return obj;
}