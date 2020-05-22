public boolean contains(Object o) {
        synchronized (mutex) {return c.contains(o);}
    }
    public boolean remove(Object o) {
        synchronized (mutex) {return c.remove(o);}
    }