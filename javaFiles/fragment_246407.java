boolean publicallyEqual(Object a, Object b) throws IllegalAccessException {
    if(a.getClass() != b.getClass())
        return false;

    for(Field f : a.getClass().getFields()) {
        Object af = f.get(a);
        Object bf = f.get(b);
        if(af == null ? bf != null : !af.equals(bf))
            return false;
    }

    return true;
}