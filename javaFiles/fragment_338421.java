if(p.getElement().equals(e))
    return p;

for(Position<E> c: children(p)) {
    Position<E> result = search(c, e);
    if (result != null) return result;
}
return null;