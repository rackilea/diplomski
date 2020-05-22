public E get(int position) throws NullPointerException {
    Object result;
    if (this.objects[position] != null) {
        result = this.objects[position];
    } else {
        throw new NullPointerException("Position is empty.");
    }
    return (E) result;
}