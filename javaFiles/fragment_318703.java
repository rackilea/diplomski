interface Copyable<T>{
    T copy();
}

class CopyableImpl implements Copyable<CopyableImpl> {
    CopyableImpl copy() { ... }
}