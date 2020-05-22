public E get(int position) throws IndexOutOfBoundsException {
    if (position < 0 || position >= this.objects.length) {
        throw new IndexOutOfBoundsException();
    }
    return (E) this.objects[position];
}