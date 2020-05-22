private Constructor<T>[] privateGetDeclaredConstructors(boolean publicOnly) {
    ...
    // No cached value available; request value from VM
    if (isInterface()) {
        @SuppressWarnings("unchecked")
        Constructor<T>[] temporaryRes = (Constructor<T>[]) new Constructor<?>[0];
        res = temporaryRes;
    } else {
        res = getDeclaredConstructors0(publicOnly);
    }
    ...
    return res;
}