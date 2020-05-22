public void notifyObservers(Object arg) {
    /*
     * a temporary array buffer, used as a snapshot of the state of
     * current Observers.
     */
    Object[] arrLocal;

    synchronized (this) {

        if (!changed)
            return;
        arrLocal = obs.toArray();
        clearChanged();
    }

    for (int i = arrLocal.length-1; i>=0; i--)
        ((Observer)arrLocal[i]).update(this, arg);
}