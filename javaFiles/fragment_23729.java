@Override public PyObject __findattr_ex__(String name) {
    if (this.containsKey(name))
    {
        return Py.java2py(this.get(name));
    }
    else
    {
        throw Py.AttributeError(name);
    }
}